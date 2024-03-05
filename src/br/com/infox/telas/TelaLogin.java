package br.com.infox.telas;
import br.com.infox.dal.ModuloConexao;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelaLogin extends JFrame implements ActionListener {
    Connection conexao = ModuloConexao.conector();
    PreparedStatement pst = null;
    ResultSet rs = null;


    public void logar() {
        //criar um variavel para pesquisar no banco de dados
        String sql = "select * from tbusuarios where login=? and senha =?";
        try {
            //as linhas abaixo preparam a consulta ao banco wm funçao do que
            //foi digitado nas caixas de texto.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarioField.getText());
            pst.setString(2, new String(senhaField.getPassword()));
            //a linha abaixo executa a query o selec acima
            rs = pst.executeQuery();
            //se existe usuario e senha correspondente
            //estrutura de seleção
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,"Login bem sucedido");
                TelaPrincipal principal = new TelaPrincipal();//para chamar preciso instanciar o objeto
                principal.setVisible(true);
                this.dispose();//essa linha permite fechar a tela de login
                conexao.close();

            } else {
                JOptionPane.showMessageDialog(null, "usuario e/ou senha invalido(s)");
            }
            //preciso tratar as exeçoes da codigo da tela principal
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton enviarButton;
    private JButton cancelarButton;
    //private JLabel statusLabel;

    public TelaLogin() {

        setTitle("Sistama X de Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(20, 20, 80, 25);
        add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(100, 20, 160, 25);
        add(usuarioField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(20, 50, 80, 25);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(100, 50, 160, 25);
        add(senhaField);

        enviarButton = new JButton("Enviar");
        enviarButton.setBounds(20, 100, 100, 25);
        enviarButton.addActionListener(this);
        add(enviarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(160, 100, 100, 25);
        cancelarButton.addActionListener(this);
        add(cancelarButton);


       /*JButton statusButton = new JButton("Status");
        statusButton.setBounds(140, 130, 100, 25);
        statusButton.addActionListener(this);
        add(statusButton);*/
    }

    public void actionPerformed(ActionEvent e) {
        logar();
        Object statusButton = null;

        if (e.getSource() == enviarButton) {
            String login = usuarioField.getText();
            String senha = new String(senhaField.getPassword());

            //JOptionPane.showMessageDialog(this, "Dados enviados:Usuario: " + login + ", Senha: " + senha);
        } else if (e.getSource() == cancelarButton) {
            usuarioField.setText("");
            senhaField.setText("");
       /* } else if (e.getSource() == statusButton) {
            boolean isConnected = verificarConexao();
            if (isConnected) {
                statusLabel.setText("Status: Conectado");
            } else {
                statusLabel.setText("Status: Desconectado");
            }*/


        }

    }

    private boolean verificarConexao() {
        return false;
    }
}
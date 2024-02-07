package br.com.infox.telas;
import javax.swing.*;
import java.awt.event.*;

public class TelaLogin extends JFrame implements ActionListener {
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton enviarButton;
    private JButton cancelarButton;

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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviarButton) {
            String login = usuarioField.getText();
            String senha = new String(senhaField.getPassword());

            // Aqui você pode implementar a lógica para processar o login e senha, por exemplo:
            // if (validarLogin(login, senha)) {
            //     JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            // } else {
            //     JOptionPane.showMessageDialog(this, "Login ou senha inválidos!");
            // }

            // Exemplo simples de mensagem de retorno:
            JOptionPane.showMessageDialog(this, "Dados enviados: Login: " + login + ", Senha: " + senha);
        } else if (e.getSource() == cancelarButton) {
            usuarioField.setText("");
            senhaField.setText("");
        }
    }
}

package br.com.infox.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("Sistema para Controle de Serviços");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel para o título
        JPanel painelTitulo = new JPanel();
        JLabel lblTitulo = new JLabel("Sistema para Controle de Serviços");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        painelTitulo.add(lblTitulo);

        // Painel para o menu
        JPanel painelMenu = new JPanel(new GridLayout(1, 4));
        JButton btnCadastro = new JButton("Cadastro");
        JButton btnRelatorio = new JButton("Relatório");
        JButton btnSobre = new JButton("Sobre");
        JButton btnSair = new JButton("Sair");

        // Adiciona ação ao botão Sair
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
                if (escolha == JOptionPane.YES_OPTION) {
                    System.exit(0); // Fecha o programa
                }
            }
        });
        // Submenu para Cadastro
        JPopupMenu menuCadastro = new JPopupMenu();
        JMenuItem itemCadastrarCliente = new JMenuItem("Cliente");
        JMenuItem itemCadastrarFuncionario = new JMenuItem("Funcionário");
        JMenuItem itemCadastrarOs = new JMenuItem("OS");

        itemCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar cliente
                JOptionPane.showMessageDialog(null, "Implemente a lógica para cadastrar cliente aqui.");
            }
        });

        itemCadastrarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar funcionário
                JOptionPane.showMessageDialog(null, "Implemente a lógica para cadastrar funcionário aqui.");
            }
        });
        itemCadastrarOs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar Os
                JOptionPane.showMessageDialog(null, "Implemente a lógica para cadastrar Os.");
            }
        });



        menuCadastro.add(itemCadastrarCliente);
        menuCadastro.add(itemCadastrarFuncionario);
        menuCadastro.add(itemCadastrarOs);

        btnCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuCadastro.show(btnCadastro, 0, btnCadastro.getHeight());
            }
        });

        painelMenu.add(btnCadastro);
        painelMenu.add(btnRelatorio);
        painelMenu.add(btnSobre);
        painelMenu.add(btnSair);

        // Adiciona o painel de menu à parte superio da tela principal
        add(painelMenu, BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
            }
        });
    }
}

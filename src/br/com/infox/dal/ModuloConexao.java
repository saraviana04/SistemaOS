package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {

    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "S@r42009";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
    }

    public static void testarConexao() {
        Connection conexao = conector();
        if (conexao != null) {
            try {
                PreparedStatement stmt = conexao.prepareStatement("SELECT 1");
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Teste de consulta bem-sucedido!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Falha ao estabelecer conexão com o banco de dados.");
        }
    }
}
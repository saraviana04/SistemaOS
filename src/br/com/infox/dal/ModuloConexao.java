package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {
    // Método responsável por estabelecer a conexão com o banco
    public static Connection conector(){
        Connection conexao = null;
        // A linha abaixo chama o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // Armazena informações referentes ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox"; // Removi o espaço em branco após dbinfox
        String user = "root";
        String password = "root";
        // Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o erro no console para debug
            return null;
        }
    }

    // Método para testar a conexão com o banco
    public static void testarConexao() {
        Connection conexao = conector();
        if (conexao != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                // Exemplo de consulta simples para testar a conexão
                PreparedStatement stmt = conexao.prepareStatement("SELECT 1");
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Teste de consulta bem-sucedido!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Feche a conexão
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

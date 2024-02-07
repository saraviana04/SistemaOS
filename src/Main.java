import br.com.infox.dal.ModuloConexao;
import br.com.infox.telas.TelaLogin;

public class Main {
    public static void main(String[] args) {
        // Testar a conexão com o banco de dados
        ModuloConexao.testarConexao();

        // Restante do seu código...
        TelaLogin cadastro = new TelaLogin();
        cadastro.setLocationRelativeTo(null); // Centraliza a janela na tela
        cadastro.setVisible(true);
    }
}


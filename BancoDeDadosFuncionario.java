import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDadosFuncionario {
    private Connection connection = null;
    private Statement statement= null;
    private ResultSet resultSet= null;

    public void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/Funcionario";
        String usuarios = "root";
        String senha = "123";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuarios, senha);
            this.statement = this.connection.createStatement();
        } catch (Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public boolean conectado() {
        if (this.connection != null) {
            return true;
        } else {
            return false;
        }
    }

    public void listar(){}

    public void detalhes(String id){}

    public void inserir(){}

    public void editar(String id){}

    public void apagar(String id){}

    public void desconectar(){
        try{
            this.connection.close();
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}

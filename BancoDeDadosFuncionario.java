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

    public void listar(){
        try{
            String query = "SELECT * FROM funcionario ORDER BY idfuncionario";
            this.resultSet = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();

            while (this.resultSet.next()) {
                System.out.println("ID - " + this.resultSet.getString("idfuncionario") + "" + this.resultSet.getString("nome_funcionario") + " " + this.resultSet.getString("contato"));//Printar todos os dados 
            }
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void inserir(String nome_funcionario, int idade, String contato){
        try {
            String query = "UPDATE funcionario nome_funcionario (nome_funcionario, idade, contato) VALUES ('"+ nome_funcionario + "', '"+ idade + "', '" + contato + ");";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void editar(String id, String nome_funcionario, int idade, String contato ){
        try {
            String query = "UPDATE funcionario SET nome_funcionario = '" + nome_funcionario + "', idade = '" + idade + "', contato = '" + contato + "' WHERE id = '" + id +";";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void apagar(String id){
        try {
            String query = "DELETE FROM funcionario WHERE id = " + id + ";";
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void desconectar(){
        try{
            this.connection.close();
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}

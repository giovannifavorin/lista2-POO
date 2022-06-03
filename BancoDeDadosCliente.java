import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDadosCliente {
    private Connection connection = null;
    private Statement statement= null;
    private ResultSet resultSet= null;

    public void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/Cliente";
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
            String query = "SELECT * FROM cliente ORDER BY idcliente";
            this.resultSet = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();

            while (this.resultSet.next()) {
                System.out.println("ID - " + this.resultSet.getString("idcliente") + "" + this.resultSet.getString("nome_cliente") + " " + this.resultSet.getString("contato"));//Printar todos os dados 
            }
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void inserir(String nome_cliente, int idade, String contato){
        try {
            String query = "UPDATE cliente (nome_cliente, idade, contato) VALUES ('"+ nome_cliente + "', '"+ idade + "', '" + contato + ");";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void editar(String id, String nome_cliente, int idade, String contato){
        try {
            String query = "UPDATE cliente SET nome_cliente = '" + nome_cliente + "', idade = '" + idade + "', contato = '" + contato + "' WHERE id = '" + id +";";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void apagar(String id){
        try {
            String query = "DELETE FROM cliente WHERE id = " + id + ";";
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

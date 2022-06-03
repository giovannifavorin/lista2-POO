import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDadosRemedio {
    private Connection connection = null;
    private Statement statement= null;
    private ResultSet resultSet= null;

    public void conectar(){
        String servidor = "jdbc:mysql://localhost:3306/farmacia";
        String usuarios = "root";
        String senha = "senai";
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

    public void listar(){//Tem q criar um novo objeto para listar informaçoes especificas de 1 remedio
        try{
            String query = "SELECT * FROM farmacia ORDER BY nome_medicamento";
            this.resultSet = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();

            while (this.resultSet.next()) {
                System.out.println("");//Printar todos os dados 
            }
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void detalhes(String id){}

    public void inserir(){//Colocar todos os dados
        try {
            String query = "UPDATE remedio SET ";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void editar(){//Colocar todos os dados
        try {
            String query = "";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void apagar(String id){
        try {
            String query = "DELETE FROM remedio WHERE id = " + id + ";";
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

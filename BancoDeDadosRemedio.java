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

    public void listar(){
        try{
            String query = "SELECT * FROM Medicamento ORDER BY idMedicamento";
            this.resultSet = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();

            while (this.resultSet.next()) {
                System.out.println("ID - " + this.resultSet.getString("idMedicamento") + "" + this.resultSet.getString("nome_laboratorio"));//Printar todos os dados 
            }
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void detalhes(String id){
        try{
            String query = "SELECT * FROM Medicamento WHERE id = " + id + ";";
            this.resultSet = this.statement.executeQuery(query);

            System.out.println("ID - " + this.resultSet.getString("idMedicamento") + " \n " + "Nome: Medicamento " + this.resultSet.getString("nome_medicamento") + " \n " + "Laboratório" + this.resultSet.getString("nome_laboratorio") + " \n " + "Preço: " + this.resultSet.getString("preco") + " \n " + "Estoque: " + this.resultSet.getString("qtd_estoque"));
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void inserir(String nome_laboratorio, Float preco, String DTVenc, String nome_medicamento, int Estoque){//Colocar todos os dados
        try {
            String query = "UPDATE Medicamento (nome_laboratorio, preco, DTVenc, nome_medicamento, Estoque) VALUES ('"+ nome_laboratorio + "', '"+ preco + "', '" + DTVenc + "', '" + nome_medicamento +"', '" + Estoque + ");";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void editar(String id, String nome_laboratorio, Float preco, String DTVenc, String nome_medicamento, int Estoque){//Colocar todos os dados
        try {
            String query = "UPDATE Medicamento SET nome_laboratorio = '" + nome_medicamento + "', nome_laboratorio = '" + nome_laboratorio+ "', preco = '" + preco + "', dt_vencimento = '" + DTVenc + "', qtd_estoque = '" + Estoque + "' WHERE id = '" + id +";";//Terminar de escrever os dados aqui
            this.statement.executeUpdate(query);
        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void apagar(String id){
        try {
            String query = "DELETE FROM Medicamento WHERE id = " + id + ";";
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

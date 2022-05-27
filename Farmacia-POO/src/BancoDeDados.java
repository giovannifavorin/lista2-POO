import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	//--------------Tentar conexao
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/farmacia_bd";
		String usuario = "root";
		String senha = "giovanni";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
	//--------------Checar conexao
	public boolean conectado() {
		if(this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	//--------------Listar
	public void listarRemedio() {
		try {
			String query =  "SELECT * FROM farmacia_bd ORDER BY nome_medicamento";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("idMedicamento") + " - Nome do laboratorio: " + this.resultset.getString("nome_laboratorio") + " - Preço: " + this.resultset.getString("preco") + " - Data de vencimento: " + this.resultset.getString("dt_vencimento") + " - Nome do medicamento: " + this.resultset.getString("nome_medicamento") + " - Quantidade no estoque: " + this.resultset.getString("qtd_estoque"));
			}
		} catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
	//--------------Inserir dados no banco de dados
	public void inserirRemedio(String nome_laboratorio, String preco, String dt_vencimento, String nome_medicamento, String qtd_estoque) {
		try {
			String query = "INSERT INTO farmacia_bd (nome do laboratorio, preco, data de vencimento, nome de medicamento, quantidade no estoque) VALUES ('" + nome_laboratorio + "','" + preco + "','" + dt_vencimento + "','" + nome_medicamento + "','" + qtd_estoque + "');";
			this.statement.executeUpdate(query);
		} catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
	//--------------Editar dados no banco de dados
	public void editarRemedio(String idMedicamento, String nome_laboratorio, String preco, String dt_vencimento, String nome_medicamento, String qtd_estoque) {
		try {
			String query = "UPDATE farmacia_bd SET nome = '" + nome_laboratorio + "', preco = '" + preco + "', data de vencimento = '" + dt_vencimento + "', nome do medicamento = '" + nome_medicamento + "', quantidade no estoque'" + qtd_estoque + "');";
			this.statement.executeUpdate(query);
		} catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
	//--------------Apagar dados no banco de dados
	public void apagarRemedio(String idMedicamento) {
		try {
			String query = "DELETE FROM farmacia_bd WHERE idMedicamento = " + idMedicamento + ";";
			this.statement.executeUpdate(query);
		} catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
	//--------------Desconectar do banco de dados
	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception erro){
			System.out.println("Erro: " + erro.getMessage());
		}
	}
}


public class Agenda {
	public static void main(String[] args) {
		BancoDeDados Estoque = new BancoDeDados();
		Estoque.conectar();
		if(Estoque.conectado()) {
			Estoque.listarRemedio();
//			Estoque.inserirRemedio();
//			Estoque.editarRemedio();
//			Estoque.apagarRemedio();
//			Estoque.desconectar();
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
	}
}

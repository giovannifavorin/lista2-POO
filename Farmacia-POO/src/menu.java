import java.util.Scanner;
public class menu {
	Scanner sc = new Scanner(System.in);
	
	public void menu1() {
		String nome;
		//----------------------------------------------------------------MENU 1
		do {
		    System.out.println("====================================================================");
		    System.out.println("        SUPER SISFARMA PREMIUM 2022");
		    System.out.println("====================================================================");
		    System.out.println("        MEDICAMENTOS");
		    System.out.println("        Escolha uma opção:");
		    System.out.println("");
		    System.out.println("    (L) Listar todos os medicamentos");
		    System.out.println("    (I) Inserir novo medicamento");
		    System.out.println("====================================================================");
		    nome = sc.nextLine();
		}while((nome != "L") && (nome != "I"));
		if(nome == "L") {
			
		}
	}
	
}

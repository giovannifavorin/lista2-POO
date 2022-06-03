import java.util.Scanner;
public class MenuCentral {
    public void MenuCentral(){
        MenuRemedio MenuRemedio = new MenuRemedio();
        MenuCliente MenuCliente = new MenuCliente();
        MenuFuncionario MenuFuncionario = new MenuFuncionario();

        try (Scanner entrada = new Scanner(System.in)) {
            int resultR, resultF, resultC;

            do {
                String respostas;
                System.out.println("====================================================================");
                System.out.println("        SUPER SISFARMA PREMIUM 2022");
                System.out.println("====================================================================");
                System.out.println("    Deseja averiguar qual banco de dados?");
                System.out.println("(R) Remédios");//Falta ajeitar o banco de dados
                System.out.println("(F) Funcionários");//falta fazer banco de dados e menu
                System.out.println("(C) Clientes");//falta fazer banco de dados e menu
                respostas = entrada.next();
                resultR = respostas.compareToIgnoreCase("r");
                resultF = respostas.compareToIgnoreCase("f");
                resultC = respostas.compareToIgnoreCase("c");
            } while ((resultR != 0) && (resultF != 0) && (resultC != 0));

            if (resultR == 0) {
                MenuRemedio.MenuRemedio();
            } else if (resultF == 0){
                MenuFuncionario.MenuFuncionario();
            } else if (resultC == 0){
                MenuCliente.MenuCliente();
            }

        } catch(Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}

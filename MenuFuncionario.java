import java.util.Scanner;
public class MenuFuncionario {
    public void MenuFuncionario(){
        BancoDeDadosFuncionario funcionario = new BancoDeDadosFuncionario();
        MenuCentral menuCentral = new MenuCentral();

        try (Scanner entrada = new Scanner(System.in)) {
            int resultL, resultI;
            do {
                String respostas;
                System.out.println("====================================================================");
                System.out.println("        SUPER SISFARMA PREMIUM 2022");
                System.out.println("====================================================================");
                System.out.println("        Funcionarios");
                System.out.println("        Escolha uma opção:\n");
                System.out.println("    (L) Listar todos os funcionarios");
                System.out.println("    (I) Inserir novo funcionario");
                System.out.println("====================================================================");
                respostas = entrada.next();
                resultL = respostas.compareToIgnoreCase("l");
                resultI = respostas.compareToIgnoreCase("i");
            } while ((resultL != 0) && (resultI != 0));

            funcionario.conectar();
            if (funcionario.conectado()) {
                if (resultL == 0) {
                    String respostas;
                    int resV, resE, resA, resX;
                    System.out.println("====================================================================");
                    System.out.println("        SUPER SISFARMA PREMIUM 2022");
                    System.out.println("        LISTAGEM DE FUNCIONÁRIOS");
                    System.out.println("====================================================================");
                    funcionario.listar();
                    do {
                        System.out.println("        Escolha uma opção:");
                        System.out.println("(V)        Voltar para a tela principal");
                        System.out.println("(E)        Exibir um funcionário pelo ID:");
                        System.out.println("(A)        Atualizar funcionário:");
                        System.out.println("(X)        Apagar funcionário:");
                        respostas = entrada.next();
                        resV = respostas.compareToIgnoreCase("v");
                        resE = respostas.compareToIgnoreCase("e");
                        resA = respostas.compareToIgnoreCase("a");
                        resX = respostas.compareToIgnoreCase("x");
                    } while ((resV != 0) && (resE != 0) && (resA != 0) && (resX != 0));
                    if (resV == 0) {
                        menuCentral.MenuCentral();
                    } else if (resE == 0) {
                        System.out.println("        Digite o ID que deseja buscar para detalhar:");
                        String IDDetallhes = entrada.next();
                        funcionario.detalhes(IDDetallhes);
                    } else if (resA == 0) {
                        System.out.println("        Digite o ID que deseja editar:");
                        String IDEditar = entrada.next();
                        funcionario.editar(IDEditar);
                    } else if (resX == 0) {
                        System.out.println("        Digite o ID que deseja apagar:");
                        String IDApagar = entrada.next();
                        funcionario.apagar(IDApagar);
                    }
                } else if (resultI == 1){
                    funcionario.inserir();
                }
                funcionario.desconectar();
            }   else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}

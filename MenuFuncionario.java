import java.util.Scanner;
public class MenuFuncionario {
    public void MenuFuncionario(){
        BancoDeDadosFuncionario funcionario = new BancoDeDadosFuncionario();
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
                    System.out.println("        LISTAGEM DE MEDICAMENTOS");
                    System.out.println("====================================================================");
                    funcionario.listar();
                    do {
                        System.out.println("        Escolha uma opção:");
                        System.out.println("(V)        Voltar para a tela principal");
                        System.out.println("(E)        Exibir um medicamento pelo ID:");
                        System.out.println("(A)        Atualizar medicamento:");
                        System.out.println("(X)        Apagar medicamento:");
                        respostas = entrada.next();
                        resV = respostas.compareToIgnoreCase("v");
                        resE = respostas.compareToIgnoreCase("e");
                        resA = respostas.compareToIgnoreCase("a");
                        resX = respostas.compareToIgnoreCase("x");
                    } while ((resV != 0) && (resE != 0) && (resA != 0) && (resX != 0));
                    if (resV == 0) {
                        
                    } else if (resE == 0) {
                        
                    } else if (resA == 0) {
                        //funcionario.editar();
                    } else if (resX == 0) {
                        //funcionario.apagar();
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

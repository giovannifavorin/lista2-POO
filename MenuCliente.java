import java.util.Scanner;
public class MenuCliente {
    public void MenuCliente(){
        BancoDeDadosCliente cliente = new BancoDeDadosCliente();
        try (Scanner entrada = new Scanner(System.in)) {
            int resultL, resultI;
            do {
                String respostas;
                System.out.println("====================================================================");
                System.out.println("        SUPER SISFARMA PREMIUM 2022");
                System.out.println("====================================================================");
                System.out.println("        Clientes");
                System.out.println("        Escolha uma opção:\n");
                System.out.println("    (L) Listar todos os clientes");
                System.out.println("    (I) Inserir novo cliente");
                System.out.println("====================================================================");
                respostas = entrada.next();
                resultL = respostas.compareToIgnoreCase("l");
                resultI = respostas.compareToIgnoreCase("i");
            } while ((resultL != 0) && (resultI != 0));

            cliente.conectar();
            if (cliente.conectado()) {
                if (resultL == 0) {
                    String respostas;
                    int resV, resE, resA, resX;
                    System.out.println("====================================================================");
                    System.out.println("        SUPER SISFARMA PREMIUM 2022");
                    System.out.println("        LISTAGEM DE CLIENTES");
                    System.out.println("====================================================================");
                    cliente.listar();
                    do {
                        System.out.println("        Escolha uma opção:");
                        System.out.println("(V)        Voltar para a tela principal");
                        System.out.println("(E)        Exibir um cliente pelo ID:");
                        System.out.println("(A)        Atualizar cliente:");
                        System.out.println("(X)        Apagar cliente:");
                        respostas = entrada.next();
                        resV = respostas.compareToIgnoreCase("v");
                        resE = respostas.compareToIgnoreCase("e");
                        resA = respostas.compareToIgnoreCase("a");
                        resX = respostas.compareToIgnoreCase("x");
                    } while ((resV != 0) && (resE != 0) && (resA != 0) && (resX != 0));
                    if (resV == 0) {
                        
                    } else if (resE == 0) {
                        
                    } else if (resA == 0) {
                        //cliente.editar();
                    } else if (resX == 0) {
                        //cliente.apagar();
                    }
                } else if (resultI == 1){
                    cliente.inserir();
                }
                cliente.desconectar();
            }   else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}

import java.util.Scanner;
public class MenuCliente {
    public void MenuCliente(){
        BancoDeDadosCliente cliente = new BancoDeDadosCliente();
        MenuCentral menuCentral = new MenuCentral();
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
                    int resV, resA, resX;
                    System.out.println("====================================================================");
                    System.out.println("        SUPER SISFARMA PREMIUM 2022");
                    System.out.println("        LISTAGEM DE CLIENTES");
                    System.out.println("====================================================================");
                    cliente.listar();
                    do {
                        System.out.println("        Escolha uma opção:");
                        System.out.println("(V)        Voltar para a tela principal");
                        System.out.println("(A)        Atualizar cliente:");
                        System.out.println("(X)        Apagar cliente:");
                        respostas = entrada.next();
                        resV = respostas.compareToIgnoreCase("v");
                        resA = respostas.compareToIgnoreCase("a");
                        resX = respostas.compareToIgnoreCase("x");
                    } while ((resV != 0) && (resA != 0) && (resX != 0));
                    if (resV == 0) {
                        menuCentral.MenuCentral();
                    } else if (resA == 0) {
                        System.out.println("        Digite o ID que deseja editar:");
                        String IDEditar = entrada.next();
                        System.out.println("        Digite o nome do cliente:");
                        String nome_cliente = entrada.next();
                        System.out.println("        Digite a idade do cliente:");
                        int idade = entrada.nextInt();
                        System.out.println("        Digite o contato do cliente:");
                        String contato = entrada.next();
                        cliente.editar(IDEditar, nome_cliente, idade, contato);
                    } else if (resX == 0) {
                        System.out.println("        Digite o ID que deseja apagar:");
                        String IDApagar = entrada.next();
                        cliente.apagar(IDApagar);
                    }
                } else if (resultI == 1){
                    System.out.println("        Digite o nome do cliente:");
                    String nome_cliente = entrada.next();
                    System.out.println("        Digite a idade do cliente:");
                    int idade = entrada.nextInt();
                    System.out.println("        Digite o contato do cliente:");
                    String contato = entrada.next();
                    cliente.inserir(nome_cliente, idade, contato);
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

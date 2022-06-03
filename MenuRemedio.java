import java.util.Date;
import java.util.Scanner;
public class MenuRemedio{
    public void MenuRemedio(){
        BancoDeDadosRemedio remedios = new BancoDeDadosRemedio();
        MenuCentral menuCentral = new MenuCentral();

        try (Scanner entrada = new Scanner(System.in)) {
            int resultL, resultI;
            do {
                String respostas;
                System.out.println("====================================================================");
                System.out.println("        SUPER SISFARMA PREMIUM 2022");
                System.out.println("====================================================================");
                System.out.println("        MEDICAMENTOS");
                System.out.println("        Escolha uma opção:\n");
                System.out.println("    (L) Listar todos os medicamentos");
                System.out.println("    (I) Inserir novo medicamento");
                System.out.println("====================================================================");
                respostas = entrada.next();
                resultL = respostas.compareToIgnoreCase("l");
                resultI = respostas.compareToIgnoreCase("i");
            } while ((resultL != 0) && (resultI != 0));

            remedios.conectar();

            if (remedios.conectado()) {
                if (resultL == 0) {
                    String respostas;
                    int resV, resE, resA, resX;
                    System.out.println("====================================================================");
                    System.out.println("        SUPER SISFARMA PREMIUM 2022");
                    System.out.println("        LISTAGEM DE MEDICAMENTOS");
                    System.out.println("====================================================================");
                    remedios.listar();
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
                        menuCentral.MenuCentral();
                    } else if (resE == 0) {
                        System.out.println("        Digite o ID que deseja buscar para detalhar:");
                        String IDDetallhes = entrada.next();
                        remedios.detalhes(IDDetallhes);
                    } else if (resA == 0) {
                        System.out.println("        Digite o ID que deseja editar:");
                        String IDEditar = entrada.next();
                        remedios.editar(IDEditar);
                    } else if (resX == 0) {
                        System.out.println("        Digite o ID que deseja apagar:");
                        String IDApagar = entrada.next();
                        remedios.apagar(IDApagar);
                    }
                } else if (resultI == 1){
                    System.out.println("        Digite o nome do laboratorio:");
                    String nomeLab = entrada.next();
                    System.out.println("        Digite o preço do remédio:");
                    float preco = entrada.nextFloat();
                    System.out.println("        Digite a data de vencimento:");
                    String DTVenc = entrada.next();
                    System.out.println("        Digite nome do medicamento:");
                    String nomeMed = entrada.next();
                    System.out.println("        Digite a quantidade no estoque:");
                    int Estoque = entrada.nextInt();
                    remedios.inserir(nomeLab, preco, DTVenc, nomeMed, Estoque);
                }
                remedios.desconectar();
            }   else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (Exception erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
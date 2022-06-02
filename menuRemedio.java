import java.util.Scanner;
public class menuRemedio{
    public void MenuRemedio(){
        BancoDeDadosRemedio remedios = new BancoDeDadosRemedio();

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
                        
                    } else if (resE == 0) {
                        
                    } else if (resA == 0) {
                        remedios.editar();
                    } else if (resX == 0) {
                        //remedios.apagar();
                    }
                } else if (resultI == 1){
                    remedios.inserir();
                }
                remedios.desconectar();
            }   else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        }
    }
    
}
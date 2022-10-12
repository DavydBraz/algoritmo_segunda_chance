import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //1,0;1,1;2,0;1,1;2,1;3,0;1,3;0,0;
        // Proc, Pag,
        String referencia = scanner.nextLine();
        String[] stringReferencia = referencia.split(";");
        System.out.println(stringReferencia);
		// SEGUNDA CHANCE
        AlgoritmoDeSubstituicao sc = new AlgoritmoSegundaChance(3);

        for (int i = 0; i < (stringReferencia.length - 1); i++) {
            System.out.println(stringReferencia[i]);
         sc.inserir(stringReferencia[i]);
         sc.imprimirQuadros();
      
        }
        System.out.println("Page Faults: " + sc.getPageFaultCount());
    }
}

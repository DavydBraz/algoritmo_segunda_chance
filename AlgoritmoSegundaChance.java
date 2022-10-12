import java.util.LinkedList;

class AlgoritmoSegundaChance extends AlgoritmoDeSubstituicao {
    LinkedList bits;
    private static int PONTEIRO = 0;

    public AlgoritmoSegundaChance(int numeroDeQuadros) {
        super(numeroDeQuadros);
        this.quadros = new LinkedList();
        this.bits = new LinkedList();

    }

    @Override
    public void inserir(String pageNumber) {
        // tmp verifica se está na memória ou não
        int tmp = quadros.indexOf(pageNumber);

        // caso a pagina ainda nao esteja na memoria
        if (tmp == -1) {
            // verifica se memoria está cheia
            if (quadros.size() < numeroDeQuadros) {

                this.quadros.add(pageNumber);
                this.bits.add(0);
            } else {
                // o ponteiro vai fazer referencia a cada item da fila
                while (this.bits.get(PONTEIRO).equals(1)) {
                    // se o bit R efetencia for == 1 ele perde sua segunda chance
                    this.bits.set(PONTEIRO, 0);
                    PONTEIRO++;
                    // ponteiro voltando ao inicio para começa o processo de eliminação
                    if (PONTEIRO == numeroDeQuadros) {
                        PONTEIRO = 0;
                    }

                }

                // ao sair do laço while o PONTEIRO terá a referência do item a ser substituido
               
                // substituicao
                //remove a page
                this.quadros.remove(PONTEIRO);
                bits.remove(PONTEIRO);

                 //coloca o novo valor no quadro
                this.quadros.add(PONTEIRO, pageNumber);
                this.bits.add(PONTEIRO, 0);

                PONTEIRO++;
                // ponteiro voltando ao inicio
                if (PONTEIRO == numeroDeQuadros) {
                    PONTEIRO = 0;
                }
            }
            numeroDeFalhas++;
        } else { // se a pagina ja esta na memoria na posição dele ele vai ganhar +1 chance
            this.bits.set(tmp, 1);

        }
    }

    @Override
    public void imprimirQuadros() {
        System.out.print("Quadros:  ");
        for (int i = 0; i < quadros.size(); i++) {
            System.out.print(quadros.get(i) + " bit: " + bits.get(i) + " ");
        }
        System.out.println();
    }
}
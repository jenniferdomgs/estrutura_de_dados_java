public class PilhaRN {
    private int topoVermelha;
    private int topoPreta;
    private Object[] itens;
    private int capacidade;

    public PilhaRN (int capacidade) {
        this.capacidade = capacidade;
        this.topoVermelha = -1;
        this.topoPreta = capacidade;
        this.itens = new Object[capacidade];
    }

    public void pushVermelha(Object o) {
        // tamanho pilhaVermelha = indice atual + 1
        if (topoVermelha + 1 == topoPreta) { // se o próximo do topoVermelha é o topoPreta então tá cheia
            redimensionaTam(capacidade * 2);
        }
        itens[++topoVermelha] = o;
    }

    public void pushPreta(Object o) {
        // tamanho pilhaPreta = capacidade - topoPreta
        if (topoVermelha + 1 == topoPreta) {
            redimensionaTam(capacidade * 2);
        }
        itens[--topoPreta] = o; // preenche de trás para frente
    }

    /*public Object popVermelha() {

    }

    public Object popPreta() {

    }*/

    public void redimensionaTam(int novaCapaciade) {
        Object novaPilha[] = new Object[novaCapaciade];

        for (int i = 0; i <= topoVermelha; i++) {
            novaPilha[i] = itens[i];
        }

        int novoTopoPreta = novaCapaciade - (capacidade - topoPreta);
        int j = novoTopoPreta;

        for (int i = topoPreta; i < capacidade; i++) {
            novaPilha[j] = itens[i];
            j++;
        }

        itens = novaPilha;
        topoPreta = novoTopoPreta;
        capacidade = novaCapaciade;
    }

    public void exibirPilha() {
        System.out.println("capacidade: " + capacidade + " | topo vermelha: " + topoVermelha + " | topo preta: " + topoPreta);
        System.out.print("pilha: [");

        for (int i = 0; i < capacidade; i++) {
            System.out.print(itens[i]);

            if (i < capacidade - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

}
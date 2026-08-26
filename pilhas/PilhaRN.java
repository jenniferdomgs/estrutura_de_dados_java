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
            redimensionaTam(capacidade * 2); // dobra antes de adicionar
        }
        // atualiza o topo e adiciona
        itens[++topoVermelha] = o;
    }

    public void pushPreta(Object o) {
        // tamanho pilhaPreta = capacidade - topoPreta
        if (topoVermelha + 1 == topoPreta) {
            redimensionaTam(capacidade * 2);
        }
        itens[--topoPreta] = o; // preenche de trás para frente
    }

    public Object popVermelha() {
        if (topoVermelha == -1) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia!");
        }

        Object itemTopoV = itens[topoVermelha];
        itens[topoVermelha] = null; // "retira o topo"
        topoVermelha--;

        if (sizePilhas() <= capacidade / 3) { // se o tamanho for 1/3 da capacidade ai força reduzir pela metade
            redimensionaTam(capacidade / 2);
        }

        return itemTopoV;
    }

    public Object popPreta() {
        if (topoPreta == capacidade) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia!");
        }

        Object itemTopoP = itens[topoPreta];
        itens[topoPreta] = null; // "retira o topo"
        topoPreta++;

        if (sizePilhas() <= capacidade / 3) { // se o tamanho for 1/3 da capacidade ai força reduzir pela metade
            redimensionaTam(capacidade / 2);
        }

        return itemTopoP;
    }

    public Object topVermelha() {
        if (isEmptyVermelha()) {
            throw new PilhaVaziaExcecao("A pilha vermelha vazia!");
        }
        return itens[topoVermelha];
    }

    public Object topPreta() {
        if (isEmptyPreta()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia!");
        }
        return itens[topoPreta];
    }

    public void redimensionaTam(int novaCapaciade) {
        Object novaPilha[] = new Object[novaCapaciade];

        // faz a copia da vermelha pro inicio da nova pilha
        for (int i = 0; i <= topoVermelha; i++) {
            novaPilha[i] = itens[i];
        }

        int novoTopoPreta = novaCapaciade - sizePreta(); // subtrai tamanho da preta da nova capacidade p ao copiar para a nova pilha manter as 2 encostadas mas a preta no final do array
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

    public int sizeVermelha() {
        return topoVermelha + 1;
    }

    public int sizePreta() {
        return capacidade - topoPreta;
    }

    public boolean isEmptyVermelha() {
        return topoVermelha == -1;
    }

    public boolean isEmptyPreta() {
        return topoPreta == capacidade;
    }

    public int sizePilhas() {
        return sizeVermelha() + sizePreta();
    }

}
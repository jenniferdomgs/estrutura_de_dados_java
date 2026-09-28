public class Sequencia {
    private PosicaoArray[] itens;
    private int tamanho;
    private int capacidade;

    public Sequencia(int capacidade) {
        this.itens = new PosicaoArray[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    private class PosicaoArray implements Position {
        int indice;
        Object elemento;

        public PosicaoArray(int indice, Object elemento) {
            this.indice = indice;
            this.elemento = elemento;
        }

        public Object element() {
            return elemento;
        }
    }

    public int size() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Position first() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Sequencia vazia!");
        }
        return itens[0];
    }

    public Position last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Sequencia vazia!");
        }
        return itens[tamanho - 1];
    }

    public Position before(Position p) {
        int rank = rankOf(p);

        if (rank == 0) {
            throw new ListaExcecao("Não há posição antes da primeira!");
        }
        return itens[rank - 1];
    }

    public Position after(Position p) {
        int rank = rankOf(p);

        if (rank == tamanho - 1) {
            throw new ListaExcecao("Não há posição depois da última!");
        }
        return itens[rank + 1];
    }

    public Position atRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        return itens[rank];
    }

    public int rankOf(Position p) {
        PosicaoArray pos = (PosicaoArray) p;

        if (pos.indice < 0 || pos.indice >= tamanho || itens[pos.indice] != pos) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        return pos.indice;
    }

    public Object replaceAtRank(int rank, Object item) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        Object antigo = itens[rank].elemento;
        itens[rank].elemento = item;   // a Position continua a mesma, oq muda é o elemento
        return antigo;
    }

    public Object replaceElement(Position p, Object item) {
        return replaceAtRank(rankOf(p), item);
    }

    public Object elemAtRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        return itens[rank].elemento;
    }

    public Object removeAtRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        PosicaoArray removida = itens[rank];

        for (int i = rank; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
            itens[i].indice = i; // atualiza o indice do item que foi deslocado
        }

        itens[--tamanho] = null;
        removida.indice = -1; // a posição removida não pode mais ser valida
        return removida.elemento;
    }

    public void insertAtRank(int rank, Object item) {
        if (rank < 0 || rank > tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        redimensionarSeq();

        for (int i = tamanho; i > rank; i--) {
            itens[i] = itens[i - 1];
            itens[i].indice = i; // atualiza o índice de quem foi deslocado
        }
        itens[rank] = new PosicaoArray(rank, item);
        tamanho++;
    }

    public void insertBefore(Position p, Object item) {
        insertAtRank(rankOf(p), item);
    }

    public void insertAfter(Position p, Object item) {
        insertAtRank(rankOf(p) + 1, item);
    }

    public void insertFirst(Object item) {
        insertAtRank(0, item);
    }

    public void insertLast(Object item) {
        insertAtRank(tamanho, item);
    }

    public Object remove(Position p) {
        return removeAtRank(rankOf(p));
    }

    public void redimensionarSeq() {
        if (tamanho == capacidade) {
            this.capacidade = this.capacidade * 2;
            PosicaoArray[] novaSeq = new PosicaoArray[this.capacidade];

            for (int i = 0; i < tamanho; i++) {
                novaSeq[i] = itens[i];
            }

            itens = novaSeq;
        }
    }
}

// Vector com array
public class Vector {
    private Object[] itens;
    private int tamanho;
    private int capacidade;

    public Vector(int capacidade) {
        this.itens = new Object[capacidade];
        this.tamanho = 0;
        this.capacidade = capacidade;
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public Object insertAtRank(int rank, int item) {
        if (rank < 0 || rank > tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        if (tamanho == capacidade) {
            capacidade *= 2;
            Object b[] = new Object[capacidade];

            for (int i = 0; i < tamanho; i++) {
                b[i] = itens[i];
            }

            itens = b;
        }

        for (int i = tamanho; i > rank; i--) {
            itens[i] = itens[i - 1];
        }
        itens[rank] = item;
        tamanho++;
        return item;
    }

    public Object removeAtRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        Object itemRemovido = itens[rank];
        for (int i = rank; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }
        tamanho--;
        return itemRemovido;
    }

    public Object replaceAtRank(int rank, int item) {
        if(rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        Object itemRemovido = itens[rank];
        itens[rank] = item;
        return itemRemovido;
    }

    public Object elemAtRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        return itens[rank];
    }
}

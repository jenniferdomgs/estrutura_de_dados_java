public class VectorLDL {
    private NodeLDL head;
    private NodeLDL tail;
    private int tamanho;

    public VectorLDL() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    private NodeLDL getNode (int rank) {
        NodeLDL atual;

        if (rank <= tamanho / 2) {
            atual = head;
            for (int i = 0; i < rank; i++) {
                atual = atual.getProximo();
            }
        } else {
            atual = tail;
            for (int i = tamanho - 1; i > rank; i--) {
                atual = atual.getAnterior();
            }
        }
        return atual;
    }

    public Object elemAtRank (int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        return getNode(rank).getItem();
    }
}

// vector implementado com lista duplamente ligada

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

    public Object insertAtRank(int rank, int item) {
        if (rank < 0 || rank > tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        NodeLDL novoNo = new NodeLDL(item);

        if (isEmpty()) {
            head = novoNo;
            tail = novoNo;

        } else if (rank == 0){
            novoNo.setProximoN(head);
            head.setAnterior(novoNo);
            head = novoNo;

        } else if (rank ==  tamanho) {
            novoNo.setAnterior(tail);
            tail.setProximoN(novoNo);
            tail = novoNo;

        } else {
            NodeLDL proximo = getNode(rank);
            NodeLDL anterior = proximo.getAnterior();

            novoNo.setProximoN(proximo);
            novoNo.setAnterior(anterior);
            anterior.setProximoN(novoNo);
            proximo.setAnterior(novoNo);
        }

        tamanho++;
        return item;
    }

    public Object removeAtRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        NodeLDL itemRemover = getNode(rank);
        Object itemRemovido = itemRemover.getItem();

        NodeLDL anterior = itemRemover.getAnterior();
        NodeLDL proximo = itemRemover.getProximo();

        if (anterior == null) {
            head = proximo;
        } else {
            anterior.setProximoN(proximo);
        }

        if (proximo == null) {
            tail = anterior;
        } else {
            proximo.setAnterior(anterior);
        }

        tamanho--;
        return itemRemovido;
    }

    public Object replaceAtRank(int rank, int item) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        NodeLDL itemRemover = getNode(rank);
        Object itemRemovido = itemRemover.getItem();
        itemRemover.setItem(item);

        return itemRemovido;
    }
}

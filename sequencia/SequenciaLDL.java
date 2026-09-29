public class SequenciaLDL {
    private NodeLDL head;
    private NodeLDL tail;
    private int tamanho;

    public SequenciaLDL() {
        head = new NodeLDL(null, null, null);
        tail = new NodeLDL(null, head, null);
        head.setProximo(tail);
        tamanho = 0;
    }

    private class NodeLDL implements Position {
        private Object elemento;
        private NodeLDL anterior;
        private NodeLDL proximo;

        public NodeLDL(Object elemento, NodeLDL anterior, NodeLDL proximo) {
            this.elemento = elemento;
            this.anterior = anterior;
            this.proximo = proximo;
        }

        public Object element() {
            return elemento;
        }

        public NodeLDL getAnterior() { return anterior; }
        public NodeLDL getProximo() { return proximo; }
        public void setAnterior(NodeLDL n) { anterior = n; }
        public void setProximo(NodeLDL n) { proximo = n; }
        public void setElemento(Object e) { elemento = e; }
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public Position first() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Sequencia vazia!");
        }
        return head.getProximo();
    }

    public Position last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Sequencia vazia!");
        }
        return tail.getAnterior();
    }

    public Position atRank(int rank) {
        if (rank < 0 || rank >= tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }

        NodeLDL node = head.getProximo();

        for (int i = 0; i < rank; i++) {
            node = node.getProximo();
        }
        return node;
    }

    public Object elemAtRank(int rank) {
        return atRank(rank).element();
    }
}
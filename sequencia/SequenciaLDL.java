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

    // verifica se a posição não foi reovida ou não é um dos sentinelas
    private NodeLDL validar(Position p) {
        if (!(p instanceof NodeLDL)) {
            throw new RankOutOfBoundsException(("Posição inválida!"));
        }
        NodeLDL node = (NodeLDL) p;
        if (node == head || node == tail || node.getProximo() == null) {
            throw new RankOutOfBoundsException(("Posição inválida!"));
        }

        return node;
    }

    private Object removerNo(NodeLDL node) {
        NodeLDL anterior = node.getAnterior();
        NodeLDL posteior = node.getProximo();
        anterior.setProximo(posteior);
        posteior.setAnterior(anterior);
        tamanho--;

        Object elemento = node.element();
        node.setElemento(null);
        node.setAnterior(null);
        node.setProximo(null); // invalida a posiçã

        return elemento;
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

    public Position before(Position p) {
        NodeLDL node = validar(p);
        NodeLDL ant = node.getAnterior();
        if (ant == head) {
            throw new ListaExcecao("Não há posição antes da primeira!");
        }

        return ant;
    }

    public Position after(Position p) {
        NodeLDL node = validar(p);
        NodeLDL prox = node.getProximo();
        if (prox == tail) {
            throw new ListaExcecao("Não há posição antes da última!");
        }

        return prox;
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

    public int rankOf(Position p) {
        NodeLDL alvo = validar(p);
        int rank = 0;
        NodeLDL node = head.getProximo();

        while (node != alvo) {
            node = node.getProximo();
            rank++;
        }

        return rank;
    }

    public Object replaceElement(Position p, Object item) {
        NodeLDL node = validar(p);
        Object antigo = node.element();
        node.setElemento(item);
        return antigo;
    }

    public Position insertFirst(Object item) {
        NodeLDL anterior = head;
        NodeLDL posterior = head.getProximo();
        NodeLDL novo = new NodeLDL(item, anterior, posterior);
        anterior.setProximo(novo);
        posterior.setAnterior(novo);
        tamanho++;
        return novo;
    }

    public Position insertLast(Object item) {
        NodeLDL anterior = tail.getAnterior();
        NodeLDL posterior = tail;
        NodeLDL novo = new NodeLDL(item, anterior, posterior);
        anterior.setProximo(novo);
        posterior.setAnterior(novo);

        tamanho++;
        return novo;
    }

    public Position insertBefore(Position p, Object item) {
        NodeLDL posterior = validar(p);
        NodeLDL anterior = posterior.getAnterior();
        NodeLDL novo = new NodeLDL(item, anterior, posterior);
        anterior.setProximo(novo);
        posterior.setAnterior(novo);

        tamanho++;
        return novo;
    }

    public Position insertAfter(Position p, Object item) {
        NodeLDL anterior = validar(p);
        NodeLDL posterior = anterior.getProximo();
        NodeLDL novo = new NodeLDL(item, anterior, posterior);
        anterior.setProximo(novo);
        posterior.setAnterior(novo);

        tamanho++;
        return novo;
    }

    public Object remove(Position p) {
        NodeLDL node = validar(p);
        return removerNo(node);
    }

    public Object elemAtRank(int rank) {
        return atRank(rank).element();
    }

    public Object replaceAtRank(int rank, Object item) {
        return replaceElement(atRank(rank), item);
    }

    public Position insertAtRank(int rank, Object item) {
        if (rank < 0 || rank > tamanho) {
            throw new RankOutOfBoundsException("Rank fora dos limites!");
        }
        if (rank == tamanho) {
            return insertLast(item);
        }

        return insertBefore(atRank(rank), item);
    }

    public Object removeAtRank(int rank) {
        return remove(atRank(rank));
    }
}
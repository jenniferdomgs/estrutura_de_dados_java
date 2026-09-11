// lista implementada com lista duplamente ligada

public class ListaLDL {
    private NodeLDL head;
    private NodeLDL tail;
    private int tamanho;

    public ListaLDL() {
        this.head = new NodeLDL(null);
        this.tail = new NodeLDL(null);
        head.setProximoN(tail);
        tail.setAnterior(head);
        this.tamanho = 0;
    }

    private NodeLDL getNode(int position) { // método auxiliar p pegar o nó
        if (position < 0 || position >= tamanho) {
            throw new ListaExcecao("posiçao inválida!");
        }

        NodeLDL atual;

        // se tá na primeira metade da lista ou do meio para frente
        if (position < tamanho / 2) {
            atual = head.getProximo();
            for (int i = 0; i < position; i++) {
                atual = atual.getProximo();            }
        } else {
            atual = tail.getAnterior();
            for (int i = tamanho - 1; i > position; i--) {
                atual = atual.getAnterior();
            }
        }

        return atual;
    }

    public int size() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object first() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("lista vazia!");
        } else {
            NodeLDL first = head.getProximo();
            return first.getItem();
        }
    }

    public Object last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("lista vazia!");
        } else {
            NodeLDL last = tail.getAnterior();
            return last.getItem();
        }
    }

    public boolean isFirst(Object item) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista vazia!");
        } else {
            return first() == item;
        }
    }

    public boolean isLast(Object item) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista vazia!");

        } else {
            return last() == item;
        }
    }

    public Object before(int position) {
        if (position >= tamanho || position < 0) {
            throw new ListaExcecao("posição inválida!");

        } else {
            NodeLDL atual = head.getProximo();
            for (int i = 0; i < position - 1; i++) {
                atual = atual.getProximo();
            }

            return atual.getItem();
        }
    }

    public Object after(int position) {
        if (position < 0 || position >= tamanho - 1) {
            throw new ListaExcecao("posição inválida!");
        }
        return getNode(position + 1).getItem();
    }

    public Object remove(int position) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("lista vazia!");
        }

        NodeLDL atual = getNode(position);

        NodeLDL noAnterior = atual.getAnterior();
        NodeLDL proximoNo = atual.getProximo();
        noAnterior.setProximoN(proximoNo);
        proximoNo.setAnterior(noAnterior);

        tamanho--;
        return atual.getItem();
    }

    public void insertFirst(Object item) {
        NodeLDL novoNo = new NodeLDL(item);
        NodeLDL proximo = head.getProximo();

        novoNo.setProximoN(proximo);
        novoNo.setAnterior(head);

        head.setProximoN(novoNo);
        proximo.setAnterior(novoNo);

        tamanho++;
    }

    public void insertLast(Object item) {
        NodeLDL novoNo = new NodeLDL(item);
        NodeLDL anterior = tail.getAnterior();

        novoNo.setProximoN(tail);
        novoNo.setAnterior(anterior);

        anterior.setProximoN(novoNo);
        tail.setAnterior(novoNo);

        tamanho++;
    }

    public void insertBefore(int position, Object item) {
        NodeLDL atual = getNode(position);

        NodeLDL novoNo = new NodeLDL(item);
        NodeLDL anterior = atual.getAnterior();

        novoNo.setProximoN(atual);
        novoNo.setAnterior(anterior);

        anterior.setProximoN(novoNo);
        atual.setAnterior(novoNo);

        tamanho++;
    }


    public void insertAfter(int position, Object item) {
        NodeLDL atual = getNode(position);

        NodeLDL novoNo = new NodeLDL(item);
        NodeLDL proximo = atual.getProximo();

        novoNo.setProximoN(proximo);
        novoNo.setAnterior(atual);

        atual.setProximoN(novoNo);
        proximo.setAnterior(novoNo);

        tamanho++;
    }

    public Object replaceElement(int position, Object item) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("lista vazia!");
        }

        NodeLDL atual = getNode(position);
        Object oldItem = atual.getItem();
        atual.setItem(item);

        return oldItem;
    }

    public void swapElements(int position1, int position2) {
        if (position1 == position2) {
            getNode(position1);
            return;
        }

        NodeLDL no1 = getNode(position1);
        NodeLDL no2 = getNode(position2);

        Object tempItem = no1.getItem();
        no1.setItem(no2.getItem());
        no2.setItem(tempItem);
    }
}

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
        } else {
            NodeLDL atual = head.getProximo();
            for (int i = 0; i <= position; i++) {
                atual = atual.getProximo();
            }
            return atual.getItem();
        }
    }

    public Object remove(int position) {
        if (position < 0 || position >= tamanho) {
            throw new ListaExcecao("posição inválida!");
        } else {
            NodeLDL atual = head.getProximo();
            for (int i = 0; i < position; i++) {
                atual = atual.getProximo();
            }

            NodeLDL noAnterior = atual.getAnterior();
            NodeLDL proximoNo = atual.getProximo();
            noAnterior.setProximoN(proximoNo);
            proximoNo.setAnterior(noAnterior);

            tamanho--;
            return atual.getItem();
        }
    }
}

// lista com array
public class Lista {
    private Object[] itens;
    private int tamanho;
    private int capacidade;

    public Lista () {
        this.capacidade = 10;
        this.itens =  new Object[capacidade];
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
            throw new ListaVaziaExcecao("Lista vazia!");
        } else {
            return itens[0];
        }
    }

    public Object last() {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista vazia!");
        } else {
            return itens[this.tamanho - 1];
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
            throw new ListaExcecao("Posição inválida!");
        } else {
            return itens[position - 1];
        }
    }

    public Object after(int position) {
        if (position >= tamanho || position < 0) {
            throw new ListaExcecao("Posição inválida!");
        } else {
            return itens[position + 1];
        }
    }

    public Object replaceElement(int position, int item) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista vazia!");
        } else if (position >= tamanho || position < 0) {
            throw new ListaExcecao("Posição inválida!");
        } else {
            Object oldItem = itens[position];
            itens[position] = item;
            return oldItem;
        }
    }

    public Object remove(int position) {
        if (isEmpty()) {
            throw new ListaVaziaExcecao("Lista vazia!");
        } else if (position < 0 || position >= tamanho) {
            throw new ListaExcecao("Posição inválida!");
        } else {
            Object itemRemover = itens[position];
            for (int i = position; i < tamanho -1; i++) {
                itens[i] = itens[i + 1];
            }
            tamanho--;
            return itemRemover;
        }
    }

    public void insertFirst(Object item) {
        if (tamanho == capacidade) {
            capacidade *= 2;
            Object[] novaLista = new Object[capacidade];
            for (int i = 0; i < tamanho; i++) {
                novaLista[i] = itens[i];
            }
            itens = novaLista;
        }
        for (int i = tamanho; i > 0; i--) {
            itens[i] = itens[i - 1];
        }
        itens[0] = item;
        tamanho++;
    }

    public void insertLast(Object item) {
        if (tamanho == capacidade) {
            capacidade *= 2;
            Object[] novoItens = new Object[capacidade];
            for (int i = 0; i < tamanho; i++) {
                novoItens[i] = itens[i];
            }
            itens = novoItens;
        }
        itens[tamanho] = item;
        tamanho++;
    }

    public void insertBefore(int position, Object item) {
        if (position < 0 || position >= tamanho) {
            throw new ListaExcecao("Posição inválida!");
        }
        if (tamanho == capacidade) {
            capacidade *= 2;
            Object[] novoItens = new Object[capacidade];
            for (int i = 0; i < tamanho; i++) {
                novoItens[i] = itens[i];
            }
            itens = novoItens;
        }
        for (int i = tamanho; i > position; i--) {
            itens[i] = itens[i - 1];
        }
        itens[position] = item;
        tamanho++;
    }

    public void insertAfter(int position, Object item) {
        if (position < 0 || position >= tamanho) {
            throw new ListaExcecao("Posição inválida!");
        }
        if (tamanho == capacidade) {
            capacidade *= 2;
            Object[] novoItens = new Object[capacidade];
            for (int i = 0; i < tamanho; i++) {
                novoItens[i] = itens[i];
            }
            itens = novoItens;
        }
        for (int i = tamanho; i > position + 1; i--) {
            itens[i] = itens[i - 1];
        }
        itens[position + 1] = item;
        tamanho++;
    }

}

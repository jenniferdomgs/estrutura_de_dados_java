// fila com lista ligada

public class FilaLL {
    private Node inicio;
    private Node fim;
    private int tamanho;

    public FilaLL() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enqueue(Object o) {
        Node novoNode = new Node(o);
        if (isEmpty()) {
            // quando tá vazia o novo nó é o inicio e fim
            inicio = novoNode;
            fim = novoNode;
        } else {
            fim.setProximo(novoNode);
            fim = novoNode;
        }
        tamanho++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        Object temp = inicio.getItem();
        inicio = inicio.getProximo();
        if (inicio == null) {
            // se voltou a ser vazia então reseta o fim
            fim = null;
        }
        tamanho--;
        return temp;
    }

    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return inicio.getItem();
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return tamanho;
    }
}


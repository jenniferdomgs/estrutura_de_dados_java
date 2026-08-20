// pilha com lista ligada

public class PilhaLL {
    private Node topo;
    private int tamanho;

    public PilhaLL() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Object item) {
        Node novoNo = new Node(item);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public Object pop() {
        if(isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        Object topoLixo = topo.getItem();
        topo = topo.getProximo();
        tamanho--;
        return topoLixo;
    }

    public Object top() {
        if(isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        return topo.getItem();
    }

    public int size() {
        return this.tamanho;
    }
}
// uma pilha é uma forma de organizar elementos em um determinada ordem - estrutura linear
// as inserções e remoções em pilhas são feitas no topo da pilha - esquema LIFO (last in, first out)

// Pilha com array
public class Pilha {
    private int topo; // ponteiro
    private Object[] itens;
    private int capacidade;
    private int fatorCrescimento;

    public Pilha (int capacidade, int crescimento) {
        this.capacidade = capacidade;
        topo = -1;
        fatorCrescimento = crescimento;
        if (crescimento <= 0) {
            fatorCrescimento = 0;
        }
        itens = new Object[capacidade];
    }

    public void push(Object o) {
        if (topo >= capacidade - 1) {
            if (fatorCrescimento == 0) {
                capacidade *= 2;
            } else {
                capacidade += fatorCrescimento;
            }
            Object b[] = new Object[capacidade];
            for (int i = 0; i < itens.length; i++) {
                b[i] = itens[i];
            }
            itens = b;
        }
        itens[++topo] = o;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        Object r = itens[topo--];
        return r;
    }

    public Object top() {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
        return itens[topo];
    }

    public void exibirPilha() {
        for(int i = 0; i <= topo; i++) {
            System.out.println(" " + itens[i]);
        }
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }
}
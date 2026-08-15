// uma pilha é uma forma de organizar elementos em um determinada ordem - estrutura linear
// as inserções e remoções em pilhas são feitas no topo da pilha - esquema LIFO (last in, first out)

public class Pilha {
    private int topo; // ponteiro
    private int[] itens;

    Pilha (int tamanho) {
        topo = -1; // inicia pilha vazia
        itens = new int[tamanho];
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public int[] getItens() {
        return itens;
    }

    public void setItens(int[] itens) {
        this.itens = itens;
    }

    public void empilhar(int valor) {
        verificarPilhaCheia();
        topo++;
        itens[topo] = valor;
    }

    public void desimpilhar() {
        verificarPilhaVazia();
        topo--;
    }

    public int retornarTopo() {
        verificarPilhaVazia();
        return itens[topo];
    }

    public void exibirPilha() {
        for(int i = 0; i <= topo; i++) {
            System.out.println(" " + itens[i]);
        }
    }

    public void verificarPilhaVazia() {
        if (topo == -1) {
            throw new PilhaVaziaExcecao("A pilha está vazia!");
        }
    }

    public void verificarPilhaCheia() {
        if (topo == itens.length - 1) {
            throw new PilhaCheiaExcecao("A pilha está cheia!");
        }
    }
}
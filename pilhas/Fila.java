public class Fila {
    private int inicio = 0, fim = 0;
    private int tamanho;
    private int incremento;
    private Object[] itens;

    public Fila(int tamanho, int incremento) {
        itens = new Object[tamanho];
        this.tamanho = tamanho;
        this.incremento = incremento;
    }

    public void enqueue(Object o) {
        if (size() == tamanho - 1) {
            int novoTam;
            if (incremento == 0) {
                novoTam = tamanho * 2;
            } else {
                novoTam = tamanho + incremento;
            }

            Object[] novaFila = new Object[novoTam];
            int novoInicio = inicio;

            for (int novoFim = 0; novoFim < size(); novoFim++) {
                novaFila[novoFim] = itens[novoInicio];
                novoInicio = (novoInicio + 1) % tamanho;
            }

            fim = size();
            inicio = 0;
            tamanho = novoTam;
            itens = novaFila;
        }
        itens[fim] = o;
        fim = (fim + 1) % tamanho;
    }

    public Object dequeue() {
        if(isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        Object temp = itens[inicio];
        inicio = (inicio + 1) % tamanho;
        return temp;
    }

    public int size() {
        return (tamanho - inicio + fim) % tamanho;
    }

    public boolean isEmpty() {
        return fim == inicio;
    }

    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return itens[inicio];
    }
}

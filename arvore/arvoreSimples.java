import java.util.Iterator;

public class arvoreSimples {
    No raiz;
    int tamanho;

    public arvoreSimples(Object valor) {
        raiz = new No(null, valor);
        tamanho = 1;
    }

    public No raiz () {
        return raiz;
    }

    public boolean isRaiz(No valor) {
        return valor == raiz;
    }

    public No pai(No valor) {
        return valor.getPai();
    }

    public Iterator filhos(No valor) {
        return valor.filhos();
    }

    public boolean isInterno(No valor) {
        return (valor.contarFilhos() > 0);
    }

    public boolean isExterno(No valor) {
        return (valor.contarFilhos() == 0);
    }

    public void addFilho(No pai, Object valor) {
        No novo = new No(pai, valor);
        pai.addFilho(novo);
        tamanho++;
    }

    public Object remove(No valor) throws InvalidNoException {
        No pai = valor.getPai();
        if (pai != null && isExterno(valor)) {
            pai.removeFilho(valor);
        } else {
            throw new InvalidNoException("Nó inválido!");
        }
        Object o = valor.getValor();
        tamanho--;
        return o;
    }

    public int exibirProfundidade(No valor) {
        int profundidade = profundidade(valor);
        return profundidade;
    }

    private int profundidade(No valor) {
        if (valor == raiz) {
            return 0;
        } else {
            return 1 + profundidade(valor.getPai());
        }
    }
}

// falta replace, swap e iterator Nos/itens

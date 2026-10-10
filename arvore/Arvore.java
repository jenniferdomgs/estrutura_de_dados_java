import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arvore {
    No raiz;
    int tamanho;

    public Arvore(Object valor) {
        raiz = new No(null, valor);
        tamanho = 1;
    }

    public int tamanho() {
        return tamanho;
    }

    public int altura(No valor) {
        if (isExterno(valor)) { // se é externo -> a altura é 0 pq não tem filhos
            return 0;
        } else { // se não, conta os filhos e retorna a altura máxima
            int h = 0;
            Iterator iter = filhos(valor);
            while (iter.hasNext()) {
                No filho = (No) iter.next();
                h = Math.max(h, altura(filho));
            }
            return 1 + h;
        }
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

    public Iterator Nos() {
        List<No> nos = new ArrayList<>();
        preOrdem(raiz, nos);
        return nos.iterator();
    }

    public Object remover(No valor) throws InvalidNoException {
        No pai = valor.getPai();
        if (pai != null && isExterno(valor)) {
            pai.removerFilho(valor);
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
        if (isRaiz(valor)) {
            return 0;
        } else {
            return 1 + profundidade(valor.getPai());
        }
    }

    public Object replace(No valor, Object novoValor) {
        Object antigo = valor.getValor();
        valor.setValor(novoValor);
        return antigo;
    }

    // a travessia preOrdem visita os nós e seus filhos percorrendo a árvore pela esquerda
    public void preOrdem(No valor, List<No> proximo) {
        proximo.add(valor);
        Iterator iter = filhos(valor);
        while (iter.hasNext()) {
            preOrdem((No) iter.next(), proximo);
        }
    }

    // percorre pela direita
    public void posOrdem(No valor, List<No> proximo) {
        Iterator iter = filhos(valor);
        while (iter.hasNext()) {
            posOrdem((No) iter.next(), proximo);
        }
        proximo.add(valor);
    }
}


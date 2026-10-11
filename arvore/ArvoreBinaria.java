public class ArvoreBinaria {
    NoAB raiz;

    public ArvoreBinaria() { }

    public ArvoreBinaria(int valor) {
        raiz = new NoAB(valor);
    }

    public boolean isRaiz(NoAB valor) {
        return valor != null && valor == raiz;
    }

    public boolean isFolha(NoAB valor) {
        return valor != null && valor.isFolha();
    }

    public int altura() { // altura contando arestas (-1 se é vazia e 0 se tem só a raiz)
        return altura(raiz);
    }

    private int altura(NoAB valor) {
        if (valor == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(valor.getEsquerdo()), altura((valor.getDireito())));
        }
    }
    public NoAB pai(NoAB valor) {
        return valor.getPai();
    }

//    public void inserir(int valor) {
//
//    }
}

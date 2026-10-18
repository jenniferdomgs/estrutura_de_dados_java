// todo nó na arvore esquerda é menor e todo nó na arvore direita é maior

public class ArvoreBinaria {
    private NoAB raiz;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public NoAB getRaiz() {
        return raiz;
    }

    public boolean isRaiz(NoAB valor) {
        return valor != null && valor == raiz;
    }

    public boolean isFolha(NoAB valor) {
        return valor != null && valor.isFolha();
    }

    public boolean isVazia() {
        return raiz == null;
    }

    private int altura(NoAB valor) {
        if (valor == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(valor.getEsquerdo()),
                    altura((valor.getDireito())));
        }
    }

    // altura contando arestas (-1 vazia e 0 se tem só a raíz)
    public int altura() { // altura contando arestas (-1 se é vazia e 0 se tem só a raiz)
        return altura(raiz);
    }

    public NoAB pai(NoAB valor) {
        return valor.getPai();
    }

    public boolean inserirNo(int valor) {
        NoAB novoNo = new NoAB(valor);

        if (raiz == null) {
            raiz = novoNo;
            tamanho++;
            return true;
        }

        NoAB noAtual = raiz;

        while (true) {
            if (valor == noAtual.getValor()) {
                return false;
            }
            if (valor < noAtual.getValor()) {
                if ( noAtual.getEsquerdo() == null) {
                    noAtual.setEsquerdo(novoNo);
                    break;
                }
                noAtual = noAtual.getEsquerdo();
            } else {
                if (noAtual.getDireito() == null) {
                    noAtual.setDireito(novoNo);
                    break;
                }
                noAtual = noAtual.getDireito();
            }
        }
        tamanho++;
        return true;
    }

    public NoAB buscar(int valor) {
        NoAB noAtual = raiz;
        while (noAtual != null) {
            if (valor == noAtual.getValor()) {
                return noAtual;
            }
            if (valor < noAtual.getValor()) {
                noAtual = noAtual.getEsquerdo();
            } else {
                noAtual = noAtual.getDireito();
            }
        }
        return null;
    }

    // menor nó de uma subarvore (o da esquerda)
    private NoAB menorNo(NoAB no) {
        while (no.getEsquerdo() != null) {
            no = no.getEsquerdo();
        }
        return no;
    }

    public boolean remover(int valor) {
        NoAB no = buscar(valor);
        if (no == null) {
            return false;
        }

        NoAB pai = no.getPai();
        int filhos = no.contarFilhos();

        if (filhos == 0) {
            // se é folha: só faz desligar do pai
            if (pai == null) {
                raiz = null;
            } else if (pai.getEsquerdo() == no) {
                pai.setEsquerdo(null);
            } else {
                pai.setDireito(null);
            }

        } else if (filhos == 1) {
            // se tem 1 filho: faz ocupar o lugar do nó removido
            NoAB filho = (no.getEsquerdo() != null) ? no.getEsquerdo() : no.getDireito();

            if (pai == null) {
                raiz = filho;
                filho.setPai(null);
            } else if (pai.getEsquerdo() == no) {
                pai.setEsquerdo(filho);
            } else {
                pai.setDireito(filho);
            }

        } else {
            // se tem 2 filhos: o sucessor é o menor nó da subarvore direita
            NoAB sucessor = menorNo(no.getDireito());

            if (sucessor.getPai() != no) {
                // o sucessor é filho esquerdo do pai dele
                // o filho direito dele sobe para o lugar dele
                sucessor.getPai().setEsquerdo(sucessor.getDireito());
                sucessor.setDireito(no.getDireito());
            }

            sucessor.setEsquerdo(no.getEsquerdo());

            // liga o sucessor ao pai do nó removido (ou faz ser nova raiz)
            if (pai == null) {
                raiz = sucessor;
                sucessor.setPai(null);
            } else if (pai.getEsquerdo() == no) {
                pai.setEsquerdo(sucessor);
            } else {
                pai.setDireito(sucessor);
            }
        }

        tamanho--;
        return true;
    }

    public void mostrar() {
        if (this.raiz == null) {
            throw new InvalidNoException("Arvore vazia!");
        }

        int l = altura() + 1;
        int c = (1 << l) - 1;

        Object[][] matriz = new Object[l][c];

        preencher(raiz, matriz, 0, 0, c - 1);

        for (Object[] linha : matriz) {
            for (Object valor : linha) {
                System.out.print(valor == null ? "\t" : valor + "\t");
            }
            System.out.println();
        }
    }

    // coloca o nó no meio do intervalo [esq, dir] da linha atual
    private void preencher(NoAB no, Object[][] matriz, int linha, int esq, int dir) {
        if (no == null) {
            return;
        }

        int meio = (esq + dir) / 2;
        matriz[linha][meio] = no.getValor();

        preencher(no.getEsquerdo(), matriz, linha + 1, esq, meio - 1);
        preencher(no.getDireito(), matriz, linha + 1, meio + 1, dir);
    }
}

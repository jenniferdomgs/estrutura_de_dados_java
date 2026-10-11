public class NoAB {
    private int valor;
    private NoAB pai;
    private NoAB esquerdo;
    private NoAB direito;

    public NoAB(int valor) {
        this.valor = valor;
    }

    public boolean isRaiz() {
        return pai == null;
    }

    public boolean isFolha() {
        return esquerdo == null && direito == null;
    }

    public int getValor() {
        return valor;
    }

    public NoAB getPai() {
        return pai;
    }

    public NoAB getDireito() {
        return direito;
    }

    public void setDireito(NoAB direito) {
        this.direito = direito;
        if (direito != null) {
            direito.pai = this;
        }
    }

    public NoAB getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(NoAB esquerdo) {
        this.esquerdo = esquerdo;
        if (esquerdo != null) {
            esquerdo.pai = this;
        }
    }

    public int contarFilhos() {
        int cont = 0;

        if (esquerdo != null) {
            cont += 1;
        }

        if (direito != null) {
            cont += 1;
        }

        return cont;
    }
}

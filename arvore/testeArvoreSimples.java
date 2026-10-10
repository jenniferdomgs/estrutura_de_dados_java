public class testeArvoreSimples {
    public static void main(String[] args) {
        arvoreSimples testeArvore = new arvoreSimples(1);
        No raiz = testeArvore.raiz();

        testeArvore.addFilho(raiz, 2);
        testeArvore.addFilho(raiz, 3);
        testeArvore.addFilho(raiz, 4);
        testeArvore.addFilho(raiz, 5);
    }
}
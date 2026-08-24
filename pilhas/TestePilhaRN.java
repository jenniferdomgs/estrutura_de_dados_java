public class TestePilhaRN {
    public static void main(String[] args) {
        PilhaRN pilha = new PilhaRN(4);

        System.out.println("--- PILHA INICIALMENTE ---");
        pilha.exibirPilha();

        pilha.pushVermelha("V1");
        pilha.pushPreta("P1");
        pilha.pushVermelha("V2");
        pilha.pushPreta("P2");
        pilha.exibirPilha();

        // já tá cheia então tem que redimensionar
        pilha.pushVermelha("V3");
        pilha.exibirPilha();
    }
}

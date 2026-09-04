public class TestePilhaRN {
    public static void main(String[] args) {
        // capacidade inicial
        PilhaRN pilha = new PilhaRN(4);

        pilha.exibirPilha();

        // enchendo a pilha
        pilha.pushVermelha("V1");
        pilha.pushPreta("P1");
        pilha.pushVermelha("V2");
        pilha.pushPreta("P2");
        pilha.exibirPilha();

        // força dobrar pra capacidade = 8
        pilha.pushVermelha("V3");
        pilha.exibirPilha();

        System.out.println("Removido da vermelha: " + pilha.popVermelha());
        pilha.exibirPilha();

        // forçar capacidade cair pra 4
        System.out.println("Removido da preta: " + pilha.popPreta());
        System.out.println("Removido da vermelha: " + pilha.popVermelha());

        pilha.exibirPilha();

        System.out.println("Removido da preta: " + pilha.popPreta());
        System.out.println("Removido da vermelha: " + pilha.popVermelha());
        pilha.exibirPilha();
    }
}
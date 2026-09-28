public class TesteSeq {

    public static void main(String[] args) {
        Sequencia teste = new Sequencia(2);

        System.out.println("Está vazia? " + teste.isEmpty() + " (esperado: true)");
        System.out.println("Tamanho: " + teste.size() + " (esperado: 0)");

        try {
            teste.first();
            System.out.println("ERRO: first() não lançou exceção");
        } catch (ListaVaziaExcecao e) {
            System.out.println("Sucesso: first() lançou ListaVaziaExcecao");
        }

        try {
            teste.last();
            System.out.println("ERRO: last() não lançou exceção");
        } catch (ListaVaziaExcecao e) {
            System.out.println("Sucesso: last() lançou ListaVaziaExcecao");
        }

        teste.insertFirst("B");
        teste.insertFirst("A");
        teste.insertLast("D");  // ativa o redimensionarSeq (capacidade inicial era 2)
        teste.insertAtRank(2, "C");

        System.out.println("Tamanho após inserções: " + teste.size() + " (esperado: 4)");
        System.out.println("Está vazia? " + teste.isEmpty() + " (esperado: false)");
        System.out.println("Item no rank 0: " + teste.elemAtRank(0) + " (esperado: A)");
        System.out.println("Item no rank 1: " + teste.elemAtRank(1) + " (esperado: B)");
        System.out.println("Item no rank 2: " + teste.elemAtRank(2) + " (esperado: C)");
        System.out.println("Item no rank 3: " + teste.elemAtRank(3) + " (esperado: D)");

        Position pPrimeiro = teste.first();
        Position pSegundo = teste.after(pPrimeiro);
        Position pUltimo = teste.last();

        System.out.println("Elemento primeiro: " + pPrimeiro.element() + " (esperado: A)");
        System.out.println("Elemento após o primeiro: " + pSegundo.element() + " (esperado: B)");
        System.out.println("Elemento antes do segundo: " + teste.before(pSegundo).element() + " (esperado: A)");
        System.out.println("Elemento último: " + pUltimo.element() + " (esperado: D)");

        try {
            teste.before(pPrimeiro);
            System.out.println("ERRO: before(first) não lançou exceção");
        } catch (ListaExcecao e) {
            System.out.println("Sucesso: before(first) lançou ListaExcecao");
        }

        try {
            teste.after(pUltimo);
            System.out.println("ERRO: after(last) não lançou exceção");
        } catch (ListaExcecao e) {
            System.out.println("Sucesso: after(last) lançou ListaExcecao");
        }

        Position posC = teste.atRank(2);
        teste.insertBefore(posC, "B.5");
        teste.insertAfter(posC, "C.5");

        System.out.println("Rank 2 após insertBefore: " + teste.elemAtRank(2) + " (esperado: B.5)");
        System.out.println("Rank 4 após insertAfter: " + teste.elemAtRank(4) + " (esperado: C.5)");
        System.out.println("Novo tamanho: " + teste.size() + " (esperado: 6)");

        Object antigoRank = teste.replaceAtRank(0, "A_MODIFICADO");
        System.out.println("Elemento substituído no rank 0: " + antigoRank + " (esperado: A)");
        System.out.println("Novo valor no rank 0: " + teste.elemAtRank(0) + " (esperado: A_MODIFICADO)");

        Object antigoElem = teste.replaceElement(posC, "C_MODIFICADO");
        System.out.println("Elemento substituído por posição: " + antigoElem + " (esperado: C)");
        System.out.println("Novo valor na posição C: " + posC.element() + " (esperado: C_MODIFICADO)");

        // Sequencia atual = [A_MODIFICADO, B, B.5, C_MODIFICADO, C.5, D]
        Object removidoRank = teste.removeAtRank(2);
        System.out.println("Removido no rank 2: " + removidoRank + " (esperado: B.5)");
        System.out.println("Novo item no rank 2: " + teste.elemAtRank(2) + " (esperado: C_MODIFICADO)");

        Position posParaRemover = teste.atRank(1);
        Object removidoPos = teste.remove(posParaRemover);
        System.out.println("Removido por posição: " + removidoPos + " (esperado: B)");
        System.out.println("Tamanho após duas remoções: " + teste.size() + " (esperado: 4)");

        try {
            teste.rankOf(posParaRemover);
            System.out.println("ERRO: rankOf em posição removida não lançou exceção");
        } catch (IllegalArgumentException e) {
            System.out.println("Sucesso: rankOf lançou IllegalArgumentException para posição removida");
        }

        try {
            teste.atRank(-1);
            System.out.println("ERRO: atRank(-1) não lançou exceção");
        } catch (RankOutOfBoundsException e) {
            System.out.println("Sucesso: atRank(-1) lançou RankOutOfBoundsException");
        }

        try {
            teste.elemAtRank(100);
            System.out.println("ERRO: elemAtRank(100) não lançou exceção");
        } catch (RankOutOfBoundsException e) {
            System.out.println("Sucesso: elemAtRank(100) lançou RankOutOfBoundsException");
        }

        try {
            teste.insertAtRank(-1, "Invalido");
            System.out.println("ERRO: insertAtRank(-1) não lançou exceção");
        } catch (RankOutOfBoundsException e) {
            System.out.println("Sucesso: insertAtRank(-1) lançou RankOutOfBoundsException");
        }

        try {
            teste.removeAtRank(10);
            System.out.println("ERRO: removeAtRank(10) não lançou exceção");
        } catch (RankOutOfBoundsException e) {
            System.out.println("Sucesso: removeAtRank(10) lançou RankOutOfBoundsException");
        }
    }
}
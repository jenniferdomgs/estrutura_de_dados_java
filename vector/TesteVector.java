// Testes do vector implementado com array

public class TesteVector {
    public static void main(String[] args) {
        // vetor vazio
        Vector v = new Vector(3);
        System.out.println("isEmpty? " + v.isEmpty());
        System.out.println("size: " + v.size());

        v.insertAtRank(0, 10);
        v.insertAtRank(1, 30);
        v.insertAtRank(1, 20); // insere no meio == 10, 20, 30
        System.out.println("size: " + v.size());
        System.out.println("isEmpty? " + v.isEmpty());
        System.out.println("elemAtRank(0): " + v.elemAtRank(0));
        System.out.println("elemAtRank(1): " + v.elemAtRank(1));
        System.out.println("elemAtRank(2): " + v.elemAtRank(2));

        Object antigo = v.replaceAtRank(1, 99);
        System.out.println("Valor antigo retornado: " + antigo);
        System.out.println("Novo elemAtRank(1): " + v.elemAtRank(1));

        Object removido = v.removeAtRank(0);
        System.out.println("Valor removido: " + removido);
        System.out.println("size depois de remover: " + v.size());
        System.out.println("elemAtRank(0) depois de remover: " + v.elemAtRank(0));

        try {
            v.elemAtRank(10);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceçãao lançada corretamente: " + e.getMessage());
        }

        try {
            v.removeAtRank(-1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            v.replaceAtRank(50, 1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Excecao lançada corretamente: " + e.getMessage());
        }

        // removendo todos os elementos
        while (!v.isEmpty()) {
            v.removeAtRank(0);
        }
        System.out.println("isEmpty? " + v.isEmpty());
        System.out.println("size depois de remover tudo: " + v.size());

        // força crescer colocando mais item que cabe
        Vector pequeno = new Vector(2);
        pequeno.insertAtRank(0, 1);
        pequeno.insertAtRank(1, 2);
        pequeno.insertAtRank(2, 3); // passa da capacidade inicial
        pequeno.insertAtRank(3, 4);
        System.out.println("size depois de crescer: " + pequeno.size());
        System.out.println("elemAtRank(0): " + pequeno.elemAtRank(0));
        System.out.println("elemAtRank(3): " + pequeno.elemAtRank(3));

    }
}
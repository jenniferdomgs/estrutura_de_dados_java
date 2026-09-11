// Testes da Lista implementada com Lista Duplamente Ligada

public class TesteListaLDL {
    public static void main(String[] args) {
        ListaLDL lista = new ListaLDL();

        System.out.println("isEmpty? " + lista.isEmpty());
        System.out.println("size: " + lista.size());

        try {
            lista.first();
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.last();
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.isFirst("x");
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.isLast("x");
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.before(0);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.after(0);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.remove(0);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.before(-1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            lista.remove(-1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        lista.insertFirst("B");
        lista.insertFirst("A"); // A, B
        lista.insertLast("C");  // A, B, C

        System.out.println("isEmpty? (esperado false): " + lista.isEmpty());
        System.out.println("size (esperado 3): " + lista.size());
        System.out.println("Primeiro (esperado A): " + lista.first());
        System.out.println("Último (esperado C): " + lista.last());
        System.out.println("isFirst 'A'? (esperado true): " + lista.isFirst("A"));
        System.out.println("isLast 'C'? (esperado true): " + lista.isLast("C"));

        lista.insertBefore(1, "X"); // A, X, B, C
        lista.insertAfter(2, "Y");  // A, X, B, Y, C

        System.out.println("Tamanho atual (esperado 5): " + lista.size());
        System.out.println("before índice 1 (esperado A): " + lista.before(1));
        System.out.println("after índice 2 (esperado Y): " + lista.after(2));

        Object antigo = lista.replaceElement(2, "Z"); // A, X, Z, Y, C
        System.out.println("Elemento substituído (esperado B): " + antigo);

        lista.swapElements(0, 4); // C, X, Z, Y, A
        System.out.println("Novo primeiro após swap (esperado C): " + lista.first());
        System.out.println("Novo último após swap (esperado A): " + lista.last());

        Object removido1 = lista.remove(2); // tira Z -> C, X, Y, A
        System.out.println("Item removido do meio (esperado Z): " + removido1);
        System.out.println("Tamanho final (esperado 4): " + lista.size());
    }
}
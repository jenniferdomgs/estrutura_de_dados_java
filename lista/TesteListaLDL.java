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

    }
}
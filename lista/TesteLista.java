// Testes da Lista implementada com array

public class TesteLista {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println("isEmpty? " + lista.isEmpty());
        System.out.println("size: " + lista.size());

        // insertLast e insertFirst
        lista.insertLast("b");
        lista.insertLast("c");
        lista.insertFirst("a"); // fica: a, b, c

        System.out.println("size: " + lista.size());
        System.out.println("isEmpty? " + lista.isEmpty());
        System.out.println("first(): " + lista.first());
        System.out.println("last(): " + lista.last());

        // insertBefore e insertAfter
        lista.insertBefore(1, "a2");  // antes de b -> a, a2, b, c
        lista.insertAfter(3, "c2");   // depois de c -> a, a2, b, c, c2

        System.out.println("Depois de insertBefore/insertAfter, size: " + lista.size());
        System.out.println("before(2): " + lista.before(2));
        System.out.println("after(2): " + lista.after(2));
        System.out.println("last(): " + lista.last());

        // isFirst e isLast
        System.out.println("isFirst(\"a\")? " + lista.isFirst("a"));
        System.out.println("isLast(\"c2\")? " + lista.isLast("c2"));

        // replaceElement
        Lista numeros = new Lista();
        numeros.insertLast(10);
        numeros.insertLast(20);
        numeros.insertLast(30);

        Object antigo = numeros.replaceElement(1, 99);
        System.out.println("Valor antigo retornado: " + antigo);
        System.out.println("Novo elemento na posição 1: " + numeros.after(0));

        // remove
        Object removido = numeros.remove(0);
        System.out.println("Valor removido: " + removido);
        System.out.println("size depois de remover: " + numeros.size());
        System.out.println("first() depois de remover: " + numeros.first());

        // exceções esperadas
        try {
            numeros.after(10);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            numeros.remove(-1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            numeros.replaceElement(50, 1);
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            numeros.insertBefore(-1, "x");
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        try {
            numeros.insertAfter(50, "x");
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        // removendo todos os elementos
        while (!numeros.isEmpty()) {
            numeros.remove(0);
        }
        System.out.println("isEmpty? " + numeros.isEmpty());
        System.out.println("size depois de remover tudo: " + numeros.size());

        try {
            numeros.first();
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (RuntimeException e) {
            System.out.println("Exceção lançada corretamente: " + e.getMessage());
        }

        // testa crescimento além da capacidade inicial (10)
        Lista grande = new Lista();
        for (int i = 0; i < 15; i++) {
            grande.insertLast(i);
        }
        System.out.println("size depois de crescer: " + grande.size());
        System.out.println("first(): " + grande.first());
        System.out.println("last(): " + grande.last());

        // testa crescimento (insertFirst)
        Lista crescendoPeloInicio = new Lista();
        for (int i = 0; i < 12; i++) {
            crescendoPeloInicio.insertFirst(i);
        }
        System.out.println("size (insertFirst 12x): " + crescendoPeloInicio.size());
        System.out.println("first() (deve ser o último inserido = 11): " + crescendoPeloInicio.first());
        System.out.println("last() (deve ser o primeiro inserido = 0): " + crescendoPeloInicio.last());
    }
}
// testes feito com fila (array e lista ligada)

public class TesteFila {
    public static void main(String[] args) {
        Fila fila = new Fila(10, 2);

        fila.enqueue("1");
        fila.enqueue("11");
        fila.enqueue("V2");
        fila.enqueue("2");

        System.out.println(fila.dequeue());

        // já tá cheia então tem que redimensionar
        System.out.println(fila.isEmpty());
        System.out.println(fila.size());

        FilaLL fila2 = new FilaLL();

        fila2.enqueue("1");
        fila2.enqueue("11");
        fila2.enqueue("V2");
        fila2.enqueue("2");

        System.out.println(fila2.dequeue());

        // já tá cheia então tem que redimensionar
        System.out.println(fila2.isEmpty());
        System.out.println(fila2.size());
    }
}

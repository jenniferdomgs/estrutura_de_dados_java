// testes feitos com as pilhas (array e lista ligada)

public class TestePilha {
    public static void main(String[] args) {
        // capacidade inicial pequena (3) e crescimento fixo de 2 p/ forçar o redimensionamento
        Pilha p1 = new Pilha(3, 2);

        System.out.println("a pilha tá vazia? " + p1.isEmpty());

        p1.push(100);
        p1.push(200);
        p1.push(300);

        System.out.println("Tamanho: " + p1.size());
        System.out.println("Topo: " + p1.top());

        p1.push(400); // aqui tem que disparar o crescimento (capacidade 3 -> 5, pois crescimento = 2)
        System.out.println("Tamanho depois de estourar a capacidade: " + p1.size());
        System.out.println("Topo: " + p1.top());

        System.out.println("Pop: " + p1.pop());
        System.out.println("Pop: " + p1.pop());
        System.out.println("Tamanho depois dos pops: " + p1.size());
        System.out.println("Topo agora: " + p1.top());

        p1.push(500);
        p1.push(600);
        System.out.println("Tamanho: " + p1.size());

        System.out.println("Pop: " + p1.pop());
        System.out.println("Pop: " + p1.pop());
        System.out.println("Pop: " + p1.pop());
        System.out.println("Pop: " + p1.pop());

        System.out.println("a pilha tá vazia? " + p1.isEmpty());
        System.out.println("Tamanho final: " + p1.size());

        // testando exceção ao desempilhar pilha vazia
        try {
            p1.pop();
        } catch (PilhaVaziaExcecao e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // testando exceção ao chamar top() em pilha vazia
        try {
            p1.top();
        } catch (PilhaVaziaExcecao e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // crescimento automático quando fatorCrescimento <= 0 (dobra a capacidade)
        System.out.println("\n--- Teste com crescimento automático (dobro da capacidade) ---");
        Pilha p2 = new Pilha(2, 0); // crescimento 0 -> vira dobro da capacidade a cada estouro
        p2.push("a");
        p2.push("b");
        p2.push("c"); // estoura capacidade 2 -> deve dobrar para 4
        p2.push("d");
        p2.push("e"); // estoura capacidade 4 -> deve dobrar para 8
        System.out.println("Tamanho p2: " + p2.size());
        p2.exibirPilha();

        // teste extra: construtor com crescimento negativo também deve tratar como 0
        System.out.println("\n--- Teste com crescimento negativo (deve virar 0 / dobro) ---");
        Pilha p3 = new Pilha(1, -5);
        p3.push("x");
        p3.push("y"); // estoura capacidade 1 -> deve dobrar para 2
        System.out.println("Tamanho p3: " + p3.size());
        p3.exibirPilha();
    }
}
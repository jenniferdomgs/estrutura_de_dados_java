// testando os métodos da Pilha

public class Main {
    public static void main(String[] args) {
        Pilha p1 = new Pilha(10);

        p1.empilhar(100);
        p1.empilhar(200);
        p1.empilhar(300);
        p1.empilhar(400);
        p1.empilhar(100);
        p1.empilhar(200);
        p1.empilhar(300);
        p1.empilhar(400);
        p1.empilhar(100);
        p1.empilhar(200);
        p1.empilhar(300);
        p1.empilhar(400);
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.desimpilhar();
        p1.empilhar(1000);
        p1.exibirPilha();
    }
}

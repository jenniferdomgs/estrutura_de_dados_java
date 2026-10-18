public class testeArvoreB {
    public static void main(String[] args) {
        ArvoreBinaria abp = new ArvoreBinaria();

        try {
            abp.mostrar();
        } catch (InvalidNoException e) {
            System.out.println(e.getMessage());
        }

        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) {
            abp.inserirNo(v);
        }

        System.out.println("\n=== Depois de inserir 50, 30, 70, 20, 40, 60, 80 ===");
        abp.mostrar();
        System.out.println("Tamanho: " + abp.getTamanho());
        System.out.println("Altura: " + abp.altura());

        abp.remover(20);   // folha
        abp.remover(30);   // 1 filho
        abp.remover(50);   // raiz com 2 filhos

        System.out.println("\n=== Depois de remover 20, 30 e 50 ===");
        abp.mostrar();
        System.out.println("Tamanho: " + abp.getTamanho());
        System.out.println("Altura: " + abp.altura());
    }
}

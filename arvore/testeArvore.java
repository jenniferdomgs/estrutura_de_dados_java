import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testeArvore {

    public static void main(String[] args) {
        Arvore arv = new Arvore("Brasil");
        No brasil = arv.raiz();

        arv.addFilho(brasil, "Nordeste");
        arv.addFilho(brasil, "Sudeste");

        // pega os nós filhos da raiz
        Iterator it = arv.filhos(brasil);
        No nordeste = (No) it.next();
        No sudeste = (No) it.next();

        arv.addFilho(nordeste, "RN");
        arv.addFilho(nordeste, "PB");
        arv.addFilho(sudeste, "SP");

        Iterator itNe = arv.filhos(nordeste);
        No rn = (No) itNe.next();
        No pb = (No) itNe.next();
        No sp = (No) arv.filhos(sudeste).next();

        // mostrar todos os nós
        System.out.println("--- Todos os nós ---");
        Iterator todos = arv.Nos();
        while (todos.hasNext()) {
            No n = (No) todos.next();
            System.out.println(n.getValor() + " (profundidade " + arv.exibirProfundidade(n) + ")");
        }

        System.out.println("Tamanho: " + arv.tamanho());
        System.out.println("Raiz: " + arv.raiz().getValor());
        System.out.println("isRaiz(Brasil): " + arv.isRaiz(brasil));
        System.out.println("isRaiz(RN): " + arv.isRaiz(rn));
        System.out.println("Pai de RN: " + arv.pai(rn).getValor());
        System.out.println("Pai de Brasil: " + arv.pai(brasil));
        System.out.print("Filhos de Nordeste: ");
        Iterator filhos = arv.filhos(nordeste);
        while (filhos.hasNext()) {
            System.out.print(((No) filhos.next()).getValor() + " ");
        }

        System.out.println("\nisInterno(Nordeste): " + arv.isInterno(nordeste));
        System.out.println("isInterno(RN): " + arv.isInterno(rn));
        System.out.println("isExterno(RN): " + arv.isExterno(rn));
        System.out.println("isExterno(Sudeste): " + arv.isExterno(sudeste));

        System.out.println("Altura de Brasil: " + arv.altura(brasil));
        System.out.println("Altura de Nordeste: " + arv.altura(nordeste));
        System.out.println("Altura de RN: " + arv.altura(rn));

        System.out.println("Profundidade de Brasil: " + arv.exibirProfundidade(brasil));
        System.out.println("Profundidade de Sudeste: " + arv.exibirProfundidade(sudeste));
        System.out.println("Profundidade de SP: " + arv.exibirProfundidade(sp));

        List<No> pre = new ArrayList<>();
        System.out.println("\n--- Árvore atual (preOrdem) ---");
        arv.preOrdem(brasil, pre);
        imprimir(pre);

        List<No> pos = new ArrayList<>();
        System.out.println("\n--- Árvore atual (posOrdem) ---");
        arv.posOrdem(brasil, pos);
        imprimir(pos);

        Object antigo = arv.replace(pb, "Paraíba");
        System.out.println("Valor antigo: " + antigo);
        System.out.println("Valor novo: " + pb.getValor());

        try {
            Object removido = arv.remover(sp);
            System.out.println("Removido: " + removido);
            System.out.println("Tamanho após remover: " + arv.tamanho());
            System.out.println("Sudeste agora é externo? " + arv.isExterno(sudeste));
        } catch (InvalidNoException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        // remover nó interno deve lançar exceção
        try {
            arv.remover(nordeste);
            System.out.println("FALHOU: deveria lançar exceção ao remover nó interno");
        } catch (InvalidNoException e) {
            System.out.println("OK, exceção ao remover nó interno: " + e.getMessage());
        }

        // remover a raiz deve lançar exceção
        try {
            arv.remover(brasil);
            System.out.println("FALHOU: deveria lançar exceção ao remover a raiz");
        } catch (InvalidNoException e) {
            System.out.println("OK, exceção ao remover a raiz: " + e.getMessage());
        }

        System.out.println("--- Árvore final (preOrdem) ---");
        List<No> fim = new ArrayList<>();
        arv.preOrdem(brasil, fim);
        imprimir(fim);
    }

    private static void imprimir(List<No> nos) {
        for (No n : nos) {
            System.out.print(n.getValor() + " ");
        }
        System.out.println();
    }
}
import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private Object valor;
    private No pai;
    private ArrayList filhos = new ArrayList();

    public No (No pai, Object valor) {
        this.valor = valor;
        this.pai = null;
    }

    public boolean isRaiz() {
        return pai == null;
    }

    public boolean isFolha() {
        return filhos.isEmpty();
    }

    public Object getValor() {
        return valor;
    }

    public No getPai() {
        return pai;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void addFilho(No filho) {
        filho.pai = this; // relação bidirecional (filho tem ref do pai e pai do filho)
        filhos.add(filho);
    }

    public boolean removeFilho(No filho) {
        if (filhos.remove(filho)) {
            filho.pai = null;
            return true;
        }
        return false;
    }

    public int contarFilhos() {
        return filhos.size();
    }

    public Iterator filhos() {
        return filhos.iterator();
    }
}

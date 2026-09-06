public class NodeLDL {
    Object item;
    NodeLDL proximo;
    NodeLDL anterior;

    public NodeLDL (Object item) {
        this.item = item;
        this.proximo = null;
        this.anterior = null;
    }

    public Object getItem() {
        return this.item;
    }

    public NodeLDL getProximo() {
        return this.proximo;
    }

    public void setProximoN (NodeLDL proximo) {
        this.proximo = proximo;
    }

    public NodeLDL getAnterior() {
        return this.anterior;
    }

    public void setAnterior (NodeLDL anterior) {
        this.anterior = anterior;
    }
}

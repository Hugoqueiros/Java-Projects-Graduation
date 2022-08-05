package listadenumeros;

public class Node {

    private Numero elemento;
    private Node proximo;

    public Node() {
        elemento = null;
        proximo = null;
    }

    public Node(Numero elemento, Node proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Numero getElemento() {
        return elemento;
    }

    public void setElemento(Numero elemento) {
        this.elemento = elemento;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Elemento: " + elemento.getCoeficiente() +"x^" + elemento.getExpoente();
    }
}

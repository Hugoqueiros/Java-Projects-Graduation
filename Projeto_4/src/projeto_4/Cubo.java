package projeto_4;

public class Cubo extends Figura_geometrica {

    private double aresta;

    public Cubo() {
        aresta = 1;
    }

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }

    public double area() {
        return 6 * Math.pow(aresta, 2);
    }
    
    public double volume(){
        return Math.pow(aresta, 3);
    }

}

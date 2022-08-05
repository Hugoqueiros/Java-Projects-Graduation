package projeto_4;

public class Esfera extends Figura_geometrica{
    
    private double raio;
    
    public Esfera() {
        raio = 1;
    }

    public Esfera(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    public double area(){
        return 4 * Math.PI * Math.pow(raio, 2);
    }
    
    public double volume(){
        return (4/3) * Math.PI * Math.pow(raio, 3);
    }

    @Override
    public String toString() {
        return "Esfera{" + "raio=" + raio + '}';
    }
}

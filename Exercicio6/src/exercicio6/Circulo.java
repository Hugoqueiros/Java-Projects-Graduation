
package exercicio6;

public class Circulo {
        private double x;
        private double y;
        private double raio;
        private double area;
        private double perimetro;


public Circulo(){
    x=0;
    y=0;
    raio=0;
    area=0;
    perimetro=0;
}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double Area() {
        area= Math.PI*(raio*raio);
        return area;
    }
    

    public void setArea(double area) {
        this.area = area;
    }

    public double Perimetro() {
        perimetro= 2*Math.PI*raio;
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    public void Aumentaraio(double raio) {
        this.raio= raio;
    }

    public void Diminuiraio(double raio) {
        this.raio = raio;
    }
       
    public boolean maiorraio(Circulo d) {
        if (this.raio > d.raio) {
            return true;
        } 
        else {
            return false;
        }
    }
    

    @Override
    public String toString() {
        return "Exercicio6- " + "x=" + x + ", y=" + y + ", raio=" + raio + ", y2=" + ", area=" + area + ", perimetro=" + perimetro ;
    }
    public void print(){
        System.out.println( "Centro X: " + x );
        System.out.println( "Centro Y: " + y );
        System.out.println( "Raio: " + raio );
        System.out.println( "Area: " + area );
        System.out.println( "Perimetro: " + perimetro );
        System.out.println("\n");

    }
}

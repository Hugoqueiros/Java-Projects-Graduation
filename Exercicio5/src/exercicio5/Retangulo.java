
package exercicio5;


public class Retangulo {
        private double x1;
        private double y1;
        private double x2;
        private double y2;
        private double base;
        private double altura;
        private double area;
        private double perimetro;

public Retangulo(){
    x1=0;
    x2=0;
    y1=0;
    y2=0;
    base=0;
    altura=0;
    area=0;
    perimetro=0;
}

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public String toString() {
        return "Exercicio5- " + "x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", base=" + base + ", altura=" + altura + ", area=" + area + ", perimetro=" + perimetro  ;
    }
    public void print(){
        System.out.println( "Abcissa da base 1: " + x1 );
        System.out.println( "Abcissa da base 2: " + x2 );
        System.out.println( "Ordenada da altura 1: " + y1 );
        System.out.println( "Ordenada da altura 2: " + y2 );
        System.out.println( "Base: " + base );
        System.out.println( "Altura: " + altura );
        System.out.println( "Area: " + area );
        System.out.println( "Perimetro: " + perimetro );
        System.out.println("\n");
    }
}


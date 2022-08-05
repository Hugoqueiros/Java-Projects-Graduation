
package exercicio5;


public class ConstroiRetangulo {
    public static void main(String[] args) {
        Retangulo d = new Retangulo(); 
        d.setX1(2.0);
        d.setY1(1.0);
        d.setX2(4.0);
        d.setY2(5.0);
        d.setBase(d.getX2()-d.getX1());
        d.setAltura(d.getY2()-d.getY1());
        d.setArea(d.getAltura()*d.getBase());
        d.setPerimetro(d.getBase()*2+d.getAltura()*2);
        d.print();
    }
}

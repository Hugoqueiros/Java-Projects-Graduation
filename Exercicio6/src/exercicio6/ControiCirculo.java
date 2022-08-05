
package exercicio6;


public class ControiCirculo {
    public static void main(String[] args) {
        Circulo d = new Circulo();
        Circulo d1= new Circulo();
        d.setX(1.0);
        d.setY(1.0);
        d.setRaio(5.0);
        d.Area();
        d.Perimetro();
        d1.setX(5.0);
        d1.setY(2.0);
        d1.setRaio(3.0);
        d1.Area();
        d1.Perimetro();

        
        d.print();
        d1.print();
        
        
        
        d.Aumentaraio(d.getRaio()+ 2.0);
        d.Area();
        d.Perimetro();
        
        d.print();
        
        d1.Diminuiraio(d1.getRaio()-1.5);
        d1.Area();
        d1.Perimetro();
        d1.print();
        
        if (d.maiorraio(d1) == true) {
            System.out.println("O 1º círculo  apresenta maior que o raio que o 2º" );
        } else {
            System.out.println("O 2º círculo  apresenta maior que o raio que o 1º" );
        }

        
    }
}    


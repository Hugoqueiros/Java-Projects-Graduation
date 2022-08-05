
package exercicio4;
import java.util.Scanner;

public class FazCalculos1 {
    public static void main(String[] args){
        Scanner leia= new Scanner (System.in);
        Cientifca c1= new Cientifca();
        
        c1.getSoma(10.5, 17.1);
        c1.getPotencia(3, 2);
        c1.getRaiz(25,0);
        c1.print();
        

    }
    
}

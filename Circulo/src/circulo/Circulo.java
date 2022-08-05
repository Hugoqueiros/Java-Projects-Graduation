/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulo;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Circulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner( System.in );
        double area, perimetro, volume;
        int r;
        System.out.printf("Insira o valor para o raio: ");
        r= leitura.nextInt();
        area= Math.PI * (r * r);
        System.out.printf("A área do círculo é %4.2f\n " ,area);
        perimetro = 2 * Math.PI * r;
        System.out.printf("A área do perimetro é %4.2f\n" , perimetro);
        volume = (4/3) * Math.PI * r;
        System.out.printf("O volume é %4.2f\n " , volume);
            
    }
    
}

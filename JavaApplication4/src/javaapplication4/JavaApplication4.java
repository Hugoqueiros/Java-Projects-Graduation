/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner( System.in );
        double a, b, c, disc;
        System.out.printf("Insira o valor para a: ");
        a= leitura.nextDouble();
        System.out.printf("Insira o valor para b: ");
        b= leitura.nextDouble();
        System.out.printf("Insira o valor para c: ");
        c= leitura.nextDouble();
        double x;
        double y;
        double z;

        x= (Math.sqrt((b*b-4*a*c)));
        
        if (x>=0){
            z= (-b+Math.sqrt((b*b-4*a*c)))/(2*a);
            y= (-b-Math.sqrt((b*b-4*a*c)))/(2*a);
            System.out.println("A raíz é " + z + " e " + y);
        }
        else{
            System.out.println("Raiz imaginárias");
        }
        
        
    }
    
}

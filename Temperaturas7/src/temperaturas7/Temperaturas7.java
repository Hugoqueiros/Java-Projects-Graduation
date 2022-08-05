/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturas7;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Temperaturas7 {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        int n[] = new int[8];
        int num, i, contador;
        double soma = 0, media;
       
        for( i = 0; i <= 6;i++){
            System.out.println("Escreva valor da temperatura " + i + ":");
            num = leia.nextInt();
            n[i] = num++;
            soma = soma + n[i];
            
           
        }
        System.out.println("");
        for (i = 0; i <= 6; i++) {    
            System.out.print(n[i] + ", ");
            }
            System.out.println("");
        
            
        media= soma / 7.0;
        System.out.println("A média é " + media);
        for ( i = 0; i<=6; i++);
            if (n[i] >= media);
                contador =+1;
            System.out.println("Houve " + contador + " valores acima da media.");
        }
        }
        
       
    
   
       
    
   

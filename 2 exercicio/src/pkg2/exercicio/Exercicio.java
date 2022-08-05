/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.exercicio;

import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Exercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner leitura = new Scanner( System.in );
        int n1, n2;
        double media;
        System.out.printf( "Insira um número: ");
        n1 = leitura.nextInt();
        System.out.printf( "Insira outro número: ");
        n2 = leitura.nextInt();
        media= (n1 + n2) / 2.0 ;
        System.out.printf( "A média é de %.2f " , media);
        // TODO code application logic here
    }
    
}

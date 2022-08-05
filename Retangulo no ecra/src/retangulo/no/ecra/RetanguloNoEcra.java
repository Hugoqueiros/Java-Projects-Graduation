/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retangulo.no.ecra;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class RetanguloNoEcra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner (System.in );
        int c,l;
        System.out.printf("Qual o comprimento desejado: ");
        c = leia.nextInt();
        System.out.printf("Qual a largura desejada: ");
        l = leia.nextInt();
        
        for (int i = 0; i < c ; i++)
            System.out.printf("*"); 
         for (int i=c; i>l+1; i++)
            System.out.println("                        *");
        for (int i = 0; i < l-1 ; i++)
            System.out.printf("\n*"); 
        for (int i = 0; i < c-1 ; i++)
            System.out.printf("*"); 
        
        
        
        
            }           
}
    


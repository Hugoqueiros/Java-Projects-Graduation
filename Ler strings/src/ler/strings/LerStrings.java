/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ler.strings;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class LerStrings {

    /**
     * @param args the command line arguments
     */
    public static int contaIniciais (String s, int c){
        char i = s.charAt(0);
        if ( i== 'A' || i== 'B' || i== 'C')
            c++;
        return c;
    }
    public static void main(String[] args) {

        Scanner leia = new Scanner( System.in );
        String str;
        int conta = 0;
        do{
            System.out.println("Insira uma String ou FIM para terminar: ");
            str= leia.nextLine().toUpperCase();
            conta = contaIniciais (str, conta);
        }while (!str.equals("FIM"));
        
        System.out.printf("Encontradas %d strings iniciadas por A, B ou C\n", conta);
        
        
        
       
        
}
}

    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contagem.inteiros;
import java.util.Scanner;
/**
 *
 * @author hugo-
 */
public class ContagemInteiros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner (System.in );
        int n, cp, cn;
        cp= 0;
        cn = 0;
        
        do {
            System.out.printf("Insira o número: ");
            n= leia.nextInt();
            if (n>0)
                cp = cp + 1;
            if (n<0)
                cn= cn + 1;
        } while (n!=0);
        System.out.printf("Foram contados " + cp + " numeros positivos");
        System.out.printf("Foram contados " + cn + " numeros negativos");
       
        
            
        
    }
    
}

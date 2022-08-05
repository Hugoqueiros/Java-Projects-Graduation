/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moedas;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Moedas {

    /**
     * @param args the command line arguments
     */
 private static int []moedas = {200,100,50,20,10,5,2,1};
    public static void calculaMoedas(int troco){
        int m;
        
        for (int i= 0; i < moedas.length; i++){
            m = troco /moedas [i];
            if (m != 0)
                System.out.println(m +" moedas de " + moedas[i]/100.0 + "€");
            troco %= moedas[i];
        }
    }
    public static void main(String[] args) {
        
        double preco;
        int troco;
        Scanner leia = new Scanner (System.in);
        System.out.println("Introduza o preço em euros: ");
        preco = leia.nextDouble();
        troco = (int)(200-preco*100);
        System.out.println("*******");
        calculaMoedas (troco);
    }
    
}
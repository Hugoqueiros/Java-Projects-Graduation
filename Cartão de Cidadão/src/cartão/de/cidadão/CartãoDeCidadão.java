/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartão.de.cidadão;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class CartãoDeCidadão {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner(System.in);
        int civil, contribuinte;
        System.out.println("Insira o número de identificação: ");
        civil = leitura.nextInt();
        System.out.println("Insira o número de contribuinte: ");
        contribuinte= leitura.nextInt();
    }
    
}



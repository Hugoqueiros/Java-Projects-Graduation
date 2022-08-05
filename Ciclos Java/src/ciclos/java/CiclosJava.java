/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclos.java;
import java.util.Scanner;
/**
 *
 * @author hugo-
 */
public class CiclosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     System.out.println("Escreva um Número: ");
        int num = new Scanner(System.in).nextInt();
        int soma = 0;

        do{
            soma += (num % 10);
            
            num /= 10;
            
        }
        while (num >0);
        System.out.println();
        System.out.printf("A soma dos algarismos é: " + soma);

    }
}

    

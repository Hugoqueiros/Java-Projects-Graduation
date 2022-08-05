/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcula.areas;

/**
 *
 * @author hugo-
 */
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Switch {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura= new Scanner(System.in);
        int mes;
        System.out.printf("Mês Pretendido: ");
        mes= leitura.nextInt();
        switch (mes){
        case "circulo" :
            System.out.printf("Janeiro");
            System.out.printf("Tem 31 dias");
            break;
        
        case "triangulo" :
            System.out.println("Fevereiro");
            System.out.printf("Tem 28 dias");
            break;
           
        case "retangulo" :
            System.out.println("Março");
            System.out.printf("Tem 31 dias");
            break;
    }
    
}

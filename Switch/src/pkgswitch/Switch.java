/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgswitch;
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
        case 1:
            System.out.printf("Janeiro");
            System.out.printf("Tem 31 dias");
            break;
        
        case 2:
            System.out.println("Fevereiro");
            System.out.printf("Tem 28 dias");
            break;
           
        case 3:
            System.out.println("Março");
            System.out.printf("Tem 31 dias");
            break;
         
        case 4:
            System.out.println("Abril");
            System.out.printf("Tem 30 dias");
            break;
         
         case 5:
            System.out.println("Maio");
            System.out.printf("Tem 31 dias");
            break;
            
         
         case 6:
            System.out.println("Junho");
            System.out.printf("Tem 30 dias");
            break;
         
        case 7:
            System.out.println("Julho");
            System.out.printf("Tem 31 dias");
            break;
        
        case 8:
            System.out.println("Agosto");
            System.out.printf("Tem 31 dias");
            break;
           
        case 9:
            System.out.println("Setembro");
            System.out.printf("Tem 30 dias");
            break;
         
        case 10:
            System.out.println("Outubro");
            System.out.printf("Tem 31 dias");
            break;
         
         case 11:
            System.out.println("Novembro");
            System.out.printf("Tem 30 dias");
            break;
         
         case 12:
            System.out.println("Dezembro");
            System.out.printf("Tem 31 dias");
            break;
    }
}
    
}

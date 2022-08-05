/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.pkg3x3;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Matriz3x3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leitura = new Scanner(System.in);
        int i;
        int j;
        int number = 0;
        int matriz[][] = new int[3][3];
        int matrizsoma [][]= new int [3][3];
        int matrizfinal [][]= new int [3][3];

        System.out.println("Escreve os dados da matriz ");

        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print("Escreve valor " + i + " , " + j + " : "+"\n");
                number = leitura.nextInt();
                matriz[i][j] = number++;
            }
        }
        System.out.println("MATRIZ 3x3");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print(matriz[i][j] + "");
            }
            System.out.println("");
        }
        
        
        System.out.println("Escreve os dados da matriz ");

        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print("Escreve valor " + i + " , " + j + " : "+"\n");
                number = leitura.nextInt();
                matrizsoma[i][j] = number++;
            }
        }
        System.out.println("MATRIZ 3x3");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print(matrizsoma[i][j] + "");
            }
            System.out.println("");
        }
        
        
        
        

    }

}
        


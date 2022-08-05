/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torres_de_hanoi;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Torres_de_Hanoi {

    /**
     * @param args the command line arguments
     */

    private static void mover(int O, int D) {
        System.out.println(O + " -> " + D);
    }
 
    // Método que implementa a recursão
    // O = pino origem
    // D = pino destino
    // T = pino de trabalho
    static void hanoi(int n, int O, int D, int T) {
 
        if (n > 0) {
            hanoi(n - 1, O, T, D);
            mover(O, D);
            hanoi(n - 1, T, D, O);
        }
 
    }
 
    // executando o hanoi
    public static void main(String[] args) {
 
        int n; // número de discos
 
        // recebe o número de discos digitado pelo usuário
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número de discos: ");
        n = entrada.nextInt();
 
        // executa o hanoi!
        Torres_de_Hanoi.hanoi(n, 1, 3, 2);
    }
}
    
    


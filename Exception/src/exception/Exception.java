/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int i = 0, soma = 0;
        boolean inputOK = false;

        /*do {
            try {
                System.out.print("Insira um nÃºmero: ");
                i = leia.nextInt();
                inputOK = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: " + e);
                leia.reset();
                leia.next();
            }
        } while (!inputOK);

        System.out.println("OK, o numero lido foi " + i);*/

        System.out.println("Insira um numero");
        i = leia.nextInt();
        while (i > 0) {
            i = i / 10;
            soma++;
        }
        System.out.println(soma);
    }
}

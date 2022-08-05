/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.java;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class ExerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leitura = new Scanner( System.in );
        String nome;
        int ano, idade;
        System.out.printf( "Insira o seu nome: ");
        nome = leitura.nextLine();
        System.out.printf( "Insira o seu ano de nascimento: ");
        ano = leitura.nextInt();
        idade= 2020 - ano;
        System.out.printf( "Olá " + nome + " tens " + idade + " anos ");
        // TODO code application logic here
    }
    
}

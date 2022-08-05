/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6.metodos;

import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Metodos {
    public static int nAlgarismos(int a) {
        int contador = 0;
        while (a != 0) {
            a = a / 10;
            contador++;
        }
        return contador;
    }

    public static int nSoma(int a) {
        int soma = 0;
        while (a != 0) {
            soma += a % 10;
            a /= 10;
        }
        return soma;
    }

    public static double nMedia(int a) {
        double media;
        media = nSoma(a) / nAlgarismos(a);
        return media;
    }

    public static int nInvertido(int a) {
        int invert = 0;
        while (a != 0) {
            invert = invert * 10 + a % 10;
            a /= 10;
        }
        return invert;
    }

    public static void nCapicua(int a) {
        int nreal = 0, result;
        while (a != 0) {
            result = a % 10;
            a /= 10;
            nreal = nInvertido(a) * 10 + result;
        }
        if (a == nreal) {
            System.out.println("O número é uma capicua");
        } else {
            System.out.println("O número não é uma capicua");
        }
    }

    public static void nPerfeito(int a) {
        int result=0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                result = i + result;
            }
        }
        if (result == a) {
            System.out.println("O número é perfeito");
        } else {
            System.out.println("O número não é perfeito");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner(System.in);
        int n1, escolha;

        System.out.print("Insira um número inteiro: ");
        n1 = leitura.nextInt();
        do {
            System.out.println("1.Número de algarismos que compõem o número");
            System.out.println("2.A soma dos algarismos");
            System.out.println("3.A média dos algarismos");
            System.out.println("4.O número invertido");
            System.out.println("5.Se o número é ou não capicua");
            System.out.println("6.Se o número é um número perfeito");
            System.out.println("7.Sair");
            System.out.printf("Escolha uma opção:");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("São " + nAlgarismos(n1) + " algarismos que compõem o número");
                    break;
                case 2:
                    System.out.println("A soma dos algarismos do número é: " + nSoma(n1));
                    break;
                case 3:
                    System.out.println("A soma dos algarismos do número é: " + nMedia(n1));
                    break;
                case 4:
                    System.out.println("O número invertido é: " + nInvertido(n1));
                    break;
                case 5:
                    nCapicua(n1);
                    break;
                case 6:
                    nPerfeito(n1);
                    break;
                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 7);
    }

}

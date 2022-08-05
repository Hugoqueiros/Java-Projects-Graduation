/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Calculadora{
    /**
     * @param args the command line arguments
     */
    public static double calcSoma(double a, double b) {
        return a + b;
    }

    public static double calcSubtracao(double a, double b) {
        return a - b;
    }

    public static double calcMultiplicacao(double a, double b) {
        return a * b;
    }

    public static double calcDivisao(double a, double b) {
        if (a >= b) {
            return a / b;
        } else {
            return b / a;
        }

    }

    public static double calcResto(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leitura = new Scanner(System.in);
        int escolha;
        double n1 = -1, n2 = -1, soma, sub, mul, div, resto;
        boolean operandos = false;

        do {
            System.out.println("1.Inserir Operandos");
            System.out.println("2.Soma");
            System.out.println("3.Subtração");
            System.out.println("4.Multiplicação");
            System.out.println("5.Divisão");
            System.out.println("6.Sair");
            System.out.printf("Escolha a opção que deseja calcular:");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    do {
                        System.out.print("Insira um número: ");
                        n1 = leitura.nextDouble();
                        System.out.print("Insira um número: ");
                        n2 = leitura.nextDouble();
                        if (n1 < 0 || n2 < 0) {
                            System.out.printf("Erro: Os operandos devem ser números inteiros não negativos");
                        }
                    } while (n1 < 0 || n2 < 0);

                    operandos = true;
                    break;
                case 2:
                    if (operandos == true) {
                        soma = calcSoma(n1, n2);
                        System.out.println("A soma dos dois números inseridos é de: " + soma);
                    } else {
                        System.out.println("Os operandos não foram inseridos corretamente");
                    }
                    break;
                case 3:
                    if (operandos == true) {
                        sub = calcSubtracao(n1, n2);
                        System.out.println("A subtração dos dois números inseridos é de: " + sub);
                    } else {
                        System.out.println("Os operandos não foram inseridos corretamente");
                    }
                    break;
                case 4:
                    if (operandos == true) {
                        mul = calcMultiplicacao(n1, n2);
                        System.out.println("A multiplicação dos dois números inseridos é de: " + mul);
                    } else {
                        System.out.println("Os operandos não foram inseridos corretamente");
                    }
                    break;
                case 5:
                    if (operandos == true) {
                        div = calcDivisao(n1, n2);
                        resto = calcResto(n1, n2);
                        System.out.println("A divisão dos dois números inseridos é de: " + div);
                        System.out.println("O resto dos dois números inseridos é de: " + resto);
                    } else {
                        System.out.println("Os operandos não foram inseridos corretamente");
                    }
                    break;

                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 6);
    }
}
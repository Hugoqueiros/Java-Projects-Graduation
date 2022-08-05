/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacoes.pkgdo.ano;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class EstacoesDoAno {
 /**
     * @param args the command line arguments
     */
    public static void calcPrimavera(int a, int b) {
        if (a > 3 && a < 6) {
            System.out.println("Estação correta");
        } else {
            if (a == 3 && b >= 20) {
                System.out.println("Estação correta");
            } else if (a == 6 && b <= 21) {
                System.out.println("Estação correta");
            } else {
                System.out.println("Estação incorreta");
            }
        }
    }
    
    public static void calcVerao(int a, int b) {
        if (a > 6 && a < 9) {
            System.out.println("Estação correta");
        } else {
            if (a == 6 && b >= 21) {
                System.out.println("Estação correta");
            } else if (a == 9 && b <= 23) {
                System.out.println("Estação correta");
            } else {
                System.out.println("Estação incorreta");
            }
        }
    }
    
    public static void calcOutono(int a, int b) {
        if (a > 9 && a < 12) {
            System.out.println("Estação correta");
        } else {
            if (a == 9 && b >= 23) {
                System.out.println("Estação correta");
            } else if (a == 12 && b <= 21) {
                System.out.println("Estação correta");
            } else {
                System.out.println("Estação incorreta");
            }
        }
    }
    
    public static void calcInverno(int a, int b) {
        if (a > 12 && a < 3) {
            System.out.println("Estação correta");
        } else {
            if (a == 12 && b >= 21) {
                System.out.println("Estação correta");
            } else if (a == 3 && b <= 20) {
                System.out.println("Estação correta");
            } else {
                System.out.println("Estação incorreta");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner(System.in);
        int escolha, mes = 0, dia = 0;
        boolean nmes = false;

        do {
            System.out.println("1.Inserir o mês");
            System.out.println("2.Primavera");
            System.out.println("3.Verão");
            System.out.println("4.Outono");
            System.out.println("5.Inverno");
            System.out.println("6.Sair");
            System.out.printf("Escolha uma opção:");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    do {
                        System.out.printf("Insira o número do mês: ");
                        mes = leitura.nextInt();
                        if (mes < 1 && mes > 12) {
                            System.out.printf("Erro: Os operandos devem ser números inteiros não negativos");
                        }
                    } while (mes < 1 && mes < 12);

                    nmes = true;
                    break;
                case 2:
                    if (nmes == true) {
                        System.out.printf("Insira o número do dia: ");
                        dia = leitura.nextInt();
                        calcPrimavera(mes, dia);
                    }
                    break;
                case 3:
                    if (nmes == true) {
                        System.out.printf("Insira o número do dia: ");
                        dia = leitura.nextInt();
                        calcVerao(mes, dia);
                    }
                    break;
                case 4:
                    if (nmes == true) {
                        System.out.printf("Insira o número do dia: ");
                        dia = leitura.nextInt();
                        calcOutono(mes, dia);
                    }
                    break;
                case 5:
                    if (nmes == true) {
                        System.out.printf("Insira o número do dia: ");
                        dia = leitura.nextInt();
                        calcInverno(mes, dia);
                    }
                    break;
                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 6);

    }
}
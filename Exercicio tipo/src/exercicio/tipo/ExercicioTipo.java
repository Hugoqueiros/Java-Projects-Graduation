/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.tipo;

import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class ExercicioTipo {
    public static void Mau(int nota) {
        if (nota > 0 && nota < 4) {
            System.out.println("Teste Mau");
        
    }
        else
            System.out.println("Errado");
    }
    
    public static void Insuficiente (int nota) {
        if (nota >= 5 && nota <= 9) {
            System.out.println("Teste insuficiente");
        }
        else
            System.out.println("Errado");
        }
    
    public static void Suficiente (int nota) {
        if (nota >= 10 && nota <= 13) {
            System.out.println("Teste Suficiente");
        }
        else
            System.out.println("Errado");
    }
    
    public static void Bom (int nota) {
        if (nota >= 14 && nota <= 17) {
            System.out.println("Teste Bom");
        }
        else
            System.out.println("Errado");
    }
    
    public static void MuitoBom (int nota) {
        if (nota >= 18 && nota <= 20) {
            System.out.println("Teste Muito Bom");
        }
        else
            System.out.println("Errado");
    }
    
    
    
    public static void main(String[] args) {

    // TODO code application logic here
        Scanner leitura = new Scanner(System.in);
        int nota = -1;
        char escolha;
        boolean notasa = false;

        do {
            System.out.println("(C) Inserir a nota: ");
            System.out.println("(M) Mau");
            System.out.println("(I) Insuficiente");
            System.out.println("(S) Suficiente");
            System.out.println("(B) Bom");
            System.out.println("(E) Muito Bom");
            System.out.println("(L) SAIR");
            System.out.printf("Escolha uma opção:");
            escolha = leitura.next().charAt(0);
            switch (escolha) {
                case 'C' :
                    do {
                        System.out.printf("Insira a nota do aluno: ");
                        nota = leitura.nextInt();
                        if (nota < 0 || nota > 20) {
                            System.out.println("Erro ");
                        }
                    } while (nota < 0 || nota > 20);

                    notasa = true;
                    break;
                case 'M':
                    if (notasa == true) {
                        Mau(nota);
                    }
                    break;
                case 'I':
                    if (notasa == true) {
                        Insuficiente(nota);
                    }
                    break;
                case 'S':
                    if (notasa == true) {
                        Suficiente(nota);
                    }
                    break;
                case 'B':
                    if (notasa == true) {
                        Bom (nota);
                    }
                    break;
                    
                
                case 'E':
                    if (notasa == true) {
                        MuitoBom (nota);
                    }
                    break;
                
                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 'L');

    }
}


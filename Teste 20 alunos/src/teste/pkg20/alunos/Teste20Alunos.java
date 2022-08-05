/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.pkg20.alunos;

import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Teste20Alunos {

    /**
     * @param args the command line arguments
     */
       public static void listarAlfabeticamente(String nome[], double nota[]) {
        for (int i = 0; i < nome.length; i++) {
            for (int j = i + 1; j < nome.length; j++) {
                if (nome[i].compareTo(nome[j]) > 0) {
                    String nome1 = nome[i];
                    nome[i] = nome[j];
                    nome[j] = nome1;
                }
            }
            System.out.println("Nome do aluno: " + nome[i]);
        }
    }

    public static void novaNota(String nome[], double nota[], double n, int p) {
        for (int i = 0; i < nota.length; i++) {
            if ((i + 1) == p) {
                nota[i] = n;
            }
        }
    }

    public static void procurarNota(String nome[], double nota[], int p) {
        for (int i = 0; i < nota.length; i++) {
            if ((i + 1) == p) {
                System.out.println("O aluno com o número " + (i + 1) + " é o " + nome[i] + " e tem " + nota[i] + " valores");
            }
        }
    }

    public static void listarAlunos(String nome[], double nota[]) {
        for (int i = 0; i < nome.length; i++) {
            System.out.println("Numero do aluno: " + (i + 1));
            System.out.println("Nome do aluno: " + nome[i]);
            System.out.println("Nota do aluno: " + nota[i] + " valores");
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leitura = new Scanner(System.in);
        double[] notaaluno = new double[2];
        String[] nomealuno = new String[2];
        int escolha;
        boolean aluno = false;

        do {
            System.out.println("1- Inserir Alunos");
            System.out.println("2- Pesquisar nota");
            System.out.println("3- Alterar nota");
            System.out.println("4- Listagem de Alunos");
            System.out.println("5- Ordenação Alfabetica");
            System.out.println("6- Sair");
            System.out.printf("Escolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    do {
                        for (int i = 0; i < 2; i++) {
                            System.out.printf("Insira a nota do aluno: ");
                            notaaluno[i] = leitura.nextDouble();
                            leitura.nextLine();
                            System.out.printf("Insira o nome do aluno: ");
                            nomealuno[i] = leitura.nextLine();
                        }
                        if (notaaluno.length < 2 && nomealuno.length < 2) {
                            System.out.printf("Não tem um numero correspondente de alunos");
                        }
                    } while (notaaluno.length < 2 && nomealuno.length < 2);
                    aluno = true;
                    break;
                case 2:
                    if (aluno == true) {
                        System.out.printf("Qual o número de aluno que deseja pesquisar?");
                        int posicao = leitura.nextInt();
                        procurarNota(nomealuno, notaaluno, posicao);
                    }
                    break;
                case 3:
                    if (aluno == true) {
                        System.out.printf("Qual o número de aluno que deseja pesquisar?");
                        int posicao = leitura.nextInt();
                        System.out.printf("Qual a nova nota que quer inserir?");
                        double newnota = leitura.nextDouble();
                        novaNota(nomealuno, notaaluno, newnota, posicao);
                    }
                    break;
                case 4:
                    if (aluno == true) {
                        listarAlunos(nomealuno, notaaluno);
                    }
                    break;
                case 5:
                    if (aluno == true) {
                        listarAlfabeticamente(nomealuno, notaaluno);
                    }
                    break;
                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 6);

    }

}
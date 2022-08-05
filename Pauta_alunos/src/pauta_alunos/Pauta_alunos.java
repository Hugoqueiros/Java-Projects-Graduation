package pauta_alunos;

import java.util.Scanner;

public class Pauta_alunos {

    private static int pesquisaBinaria(int nota_alunos[], String nome_alunos[], String nome) {
        int maior = nome_alunos.length - 1, menor = 0;
        for (int i = 0; i < nome_alunos.length; i++) {
            if (nome_alunos[i].equals(nome)) {
                while (menor <= maior) {
                    int media = (menor + maior) / 2;
                    int b = nome_alunos[media].compareTo(nome);
                    if (b > 0) {
                        maior = media - 1;
                        return maior;
                    } else if (b == 0) {
                        return media;
                    } else {
                        menor = media + 1;
                        return menor;
                    }

                }
            }

        }
        return -1;
    }

    public static int pesquisaLinear(int nota_alunos[],String nome_alunos[], int nota) {
        int i = 0;
        while (i < nota_alunos.length && nota_alunos[i] != nota) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int escolha, a = 0;
        String x = "";
        int z = 0;
        boolean aluno = false;
        boolean ordem = false;
        int nota_alunos[] = new int[a];
        String nome_alunos[] = new String[a];
        do {
            System.out.println("1- Alunos na Turma");
            System.out.println("2- Inserir Nome do Aluno e respetivas Notas");
            System.out.println("3- Listagem dos Alunos e das Notas");
            System.out.println("4- Ordem Alfabética dos Alunos");
            System.out.println("5- Ordem Decrescente das Notas");
            System.out.println("6- Pesquisar Aluno");
            System.out.println("7- Pesquisar nota através da Pesquisa Binária");
            System.out.println("8- Pesquisar nota através da Pesquisa Linear");
            System.out.println("9- Sair do Programa");
            System.out.printf("Escolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Quantos alunos tem a turma?");
                    a = leitura.nextInt();
                    nome_alunos = new String[a];
                    nota_alunos = new int[a];
                    aluno = true;
                    break;
                case 2:
                    if (aluno == true) {
                        for (int i = 0; i < a; i++) {
                            System.out.printf("Insira um aluno: ");
                            leitura.nextLine();
                            nome_alunos[i] = leitura.nextLine();
                            System.out.printf("Insira a classificação do aluno: ");
                            nota_alunos[i] = leitura.nextInt();
                        }
                    }
                    break;
                case 3:
                    if (aluno == true) {
                        System.out.println("Listagem de Alunos e das Notas");
                        for (int i = 0; i < a; i++) {
                            System.out.println("Nome do Aluno: " + nome_alunos[i]);
                            System.out.println("Nota do Aluno: " + nota_alunos[i] + " valores");
                        }
                      ordem=true;
                    }
                    break;
                case 4:
                    if (aluno == true) {
                        for (int i = 0; i < a; i++) {
                            for (int j = i + 1; j < a; j++) {
                                if (nome_alunos[i].compareTo(nome_alunos[j]) > 0) {
                                    x = nome_alunos[i];
                                    z = nota_alunos[i];
                                    nome_alunos[i] = nome_alunos[j];
                                    nota_alunos[i] = nota_alunos[j];
                                    nome_alunos[j] = x;
                                    nota_alunos[j] = z;
                                }
                            }
                            System.out.print(nome_alunos[i] + " ");
                            System.out.print(nota_alunos[i] + " ");
                        }
                    }
                    break;
                case 5:
                    if (aluno == true) {
                        for (int i = 0; i < a; i++) {
                            for (int j = i + 1; j < a; j++) {
                                if (nota_alunos[i] > nota_alunos[j]) {
                                    z = nota_alunos[i];
                                    x = nome_alunos[i];
                                    nota_alunos[i] = nota_alunos[j];
                                    nome_alunos[i] = nome_alunos[j];
                                    nota_alunos[j] = z;
                                    nome_alunos[j] = x;
                                }
                            }
                            System.out.print(nota_alunos[i] + " ");
                            System.out.print(nome_alunos[i] + " ");
                        }
                        ordem = true;
                        break;
                    }
                case 6:
                    if (aluno == true) {
                        String name;
                        System.out.print("Nome do Aluno?");
                        leitura.nextLine();
                        name = leitura.nextLine();
                        for (int i = 0; i < a; i++) {
                            if (nome_alunos[i].equals(name)) {
                                System.out.println("O aluno " + name + " tem " + nota_alunos[i] + " valores");
                            }
                        }
                        break;
                    }
                case 7:
                    if (aluno == true && ordem == true) {
                        System.out.println("Digite o nome do Aluno que pretende pesquisar?");
                        String nome;
                        leitura.nextLine();
                        nome = leitura.nextLine();
                        int e = pesquisaBinaria(nota_alunos, nome_alunos, nome);
                        System.out.println(e);
                        if (e >= 0) {
                            System.out.println("O aluno " + nome + " tem " + nota_alunos[e] + " valores e está na " + e + "ª posição do vetor");
                        } else {
                            System.out.println("Não há aluno correspondente ao que inseriu");
                        }

                    }
                    break;
                case 8:
                    if (aluno == true && ordem==true) {
                        int nota;
                        System.out.println("Digite o Nota do Aluno que pretende pesquisar?");
                        nota=leitura.nextInt();
                        int k = pesquisaLinear(nota_alunos,nome_alunos, nota);
                        System.out.println("O aluno "+nome_alunos[k]+ " tem " + nota+ " na "+ k + "ª posição");
                };

            }
        } while (escolha != 9);
    }
}

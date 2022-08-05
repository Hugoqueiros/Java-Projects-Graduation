package projetolti;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.lang.*;

public class ProjetoLTI {

    public static void main(String[] args) throws IOException {

        Scanner leia = new Scanner(System.in);
        Random aleatorio = new Random();
        String f = "projetolti.csv";
        int escolha, menor = 0, maior, n = 2;
        double t_inicial, t_final, t;
        int numero_aleatorio[] = new int[n];
        boolean n_contido = false;
        Ficheiro.criaFicheiro(f);
        Ficheiro.abreEscrita(f);
        do {
            System.out.println("1- Pesquisa linear");
            System.out.println("2- Pesquisa binária");
            System.out.println("3- Sair do programa");
            System.out.printf("\nDigite o Número da Operação que pretende Realizar: ");
            escolha = leia.nextInt();

            switch (escolha) {
                case 1:
                    while (n < 131073) {
                        System.out.println("\nNúmeros Gerados: ");
                        numero_aleatorio = new int[n];
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            numero_aleatorio[i] = aleatorio.nextInt(100);
                            System.out.println("Numero gerado: " + numero_aleatorio[i]);
                        }
                        System.out.println("\nNúmeros Ordenados: ");
                        t_inicial = System.nanoTime();
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            for (int j = i + 1; j < numero_aleatorio.length; j++) {
                                if (numero_aleatorio[i] > numero_aleatorio[j]) {
                                    int z = numero_aleatorio[i];
                                    numero_aleatorio[i] = numero_aleatorio[j];
                                    numero_aleatorio[j] = z;

                                }
                            }
                            System.out.println(numero_aleatorio[i]);
                        }
                        t_final = System.nanoTime();
                        int posicao = 0, numero_pesquisa;
                        System.out.println("Digite o Número que pretende Pesquisar: ");
                        numero_pesquisa = leia.nextInt();
                        while (posicao < numero_aleatorio.length && numero_aleatorio[posicao] != numero_pesquisa) {
                            posicao++;
                        }
                        if (posicao == n) {
                            System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
                        } else {
                            System.out.println("\nO numero " + numero_pesquisa + " está na  " + posicao + "ª posição.");
                        }
                        t = t_final - t_inicial;
                        System.out.println("\nO tempo de execução foi de " + t + " x 10^-9 segundos");
                        String escreveVetor = "" + numero_aleatorio.length;
                        String escreveTempo = "" + t;
                        Ficheiro.escreveValores(escreveVetor, escreveTempo);
                        n = n * 2;
                    }
                    n = 2;
                    break;

                case 2:
                    while (n < 131073) {
                        numero_aleatorio = new int[n];
                        System.out.println("Números Gerados: ");
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            numero_aleatorio[i] = aleatorio.nextInt(100);
                        }
                        System.out.println("Números Ordenados: ");
                        t_inicial = System.nanoTime();
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            for (int j = i + 1; j < numero_aleatorio.length; j++) {
                                if (numero_aleatorio[i] > numero_aleatorio[j]) {
                                    int z = numero_aleatorio[i];
                                    numero_aleatorio[i] = numero_aleatorio[j];
                                    numero_aleatorio[j] = z;

                                }
                            }
                            System.out.println(numero_aleatorio[i]);
                        }
                        t_final = System.nanoTime();
                        System.out.println("");
                        System.out.println("\nDigite o Número que pretende Pesquisar: ");
                        int numero_pesquisa = leia.nextInt();
                        maior = numero_aleatorio.length - 1;
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            if (numero_aleatorio[i] == numero_pesquisa) {
                                while (menor <= maior) {
                                    int valor_medio = (menor + maior) / 2;
                                    if (numero_aleatorio[valor_medio] > 0) {
                                        maior = valor_medio - 1;
                                        System.out.println("\nO numero " + numero_pesquisa + " está na  " + i + "ª posição.");
                                        n_contido = true;
                                        break;
                                    } else if (numero_aleatorio[valor_medio] == 0) {
                                        System.out.println("\nO numero " + numero_pesquisa + " está na  " + i + "ª posição.");
                                        n_contido = true;
                                        break;
                                    } else {
                                        menor = valor_medio + 1;
                                        System.out.println("\nO numero " + numero_pesquisa + " está na  " + i + "ª posição.");
                                        n_contido = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (n_contido == false) {
                            System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
                        }
                        t = t_final - t_inicial;
                        System.out.println("\nO tempo de execução foi de " + t + " x 10^-9 segundos");
                        String escreveVetor = "" + numero_aleatorio.length;
                        String escreveTempo = "" + t;
                        Ficheiro.escreveValores(escreveVetor, escreveTempo);
                        n = n * 2;
                    }
                    n = 2;
                    break;

                default:
                    System.out.println("\nPrograma Terminado");
                    Ficheiro.fechaEscrita();
                    break;
            }
        } while (escolha != 3);
    }
}

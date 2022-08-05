package projeto_linguagens_programacao;

import java.util.Scanner;
import java.util.Random;
import java.lang.*;
import java.io.IOException;

public class Projeto_Linguagens_Programacao {

    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String f = "projeto.csv";
        Random gerador = new Random();
        //indicar o quantidade de números no vetor
        int n = 8;
        int numero_aleatorio[] = new int[n];
        int escolha;
        double t_final, t_inicial, t;
        //menu interativo para a escolha da opção correspondente ao utilizador
        Ficheiro.abreFicheiro(f);
        do {
            System.out.println("1- Pesquisa Linear");
            System.out.println("2- Pesquisa Binária");
            System.out.println("3- Sair do Programa");
            System.out.printf("\nDigite o Número da Operação que pretende Realizar: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            numero_aleatorio[i] = gerador.nextInt(10000);
                            System.out.println("Números gerado: " + numero_aleatorio[i]);
                        }
                        t_inicial = System.nanoTime();
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            for (int j = i + 1; j < numero_aleatorio.length; j++) {
                                if (numero_aleatorio[i] > numero_aleatorio[j]) {
                                    int z = numero_aleatorio[i];
                                    numero_aleatorio[i] = numero_aleatorio[j];
                                    numero_aleatorio[j] = z;

                                }
                            }
                            System.out.println("Números Ordenados: " + numero_aleatorio[i]);
                        }
                        t_final = System.nanoTime();
                        int posicao = 0;
                        System.out.printf("\nDigite o Número que pretende Pesquisar: ");
                        int p_numero = leitura.nextInt();

                        if (numero_aleatorio[posicao] == p_numero) {
                            while (posicao < numero_aleatorio.length && numero_aleatorio[posicao] != p_numero) {
                                posicao++;
                            }
                            System.out.println("\nO número " + p_numero + " encontra-se na " + posicao + "ª posição do vetor");
                        } else {
                            System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
                        }
                        //tempo correspondente ao tempo de execução da pesquisa linear
                        t = t_final - t_inicial;
                        System.out.println("O tempo de execução foi de " + t + " x 10^-9 segundos");
                        String escreveN = "" + numero_aleatorio.length;
                        String escreveT = "" + t;
                        Ficheiro.escreveValores(escreveN, escreveT);
                    break;

                case 2:

                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            numero_aleatorio[i] = gerador.nextInt(100);
                            System.out.println("Números gerado: " + numero_aleatorio[i]);
                        }
                        System.out.println("");
                        t_inicial = System.nanoTime();
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            for (int j = i + 1; j < numero_aleatorio.length; j++) {
                                if (numero_aleatorio[i] > numero_aleatorio[j]) {
                                    int z = numero_aleatorio[i];
                                    numero_aleatorio[i] = numero_aleatorio[j];
                                    numero_aleatorio[j] = z;
                                }
                            }
                            System.out.println("Números Ordenados: " + numero_aleatorio[i]);
                        }
                        t_final = System.nanoTime();
                        //após a ordenação é possível a realização da pesquisa binária

                        int min = 0,
                                max = numero_aleatorio.length - 1,
                                valor_medio;
                        //Leitura do número pretendido para a pesquisa
                        System.out.printf("\nDigite o Número que pretende Pesquisar: ");
                        int p_numerob = leitura.nextInt();
                        for (int i = 0; i < numero_aleatorio.length; i++) {
                            if (numero_aleatorio[i] == p_numerob) {
                                while (min <= max) {
                                    valor_medio = (min + max) / 2;
                                    if (numero_aleatorio[valor_medio] > 0) {
                                        max = valor_medio - 1;
                                        System.out.println("\nO numero " + p_numerob + " está na posição " + i);
                                        break;
                                    } else if (numero_aleatorio[valor_medio] == 0) {
                                        System.out.println("\nO numero " + p_numerob + " está na posição " + i);
                                        break;
                                    } else {
                                        min = valor_medio + 1;
                                        System.out.println("\nO numero " + p_numerob + " está na posição " + i);
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
                                break;
                            }
                        }
                        //tempo final da execução da pesquisa binária
                        //tempo correspondente ao tempo de execução da pesquisa binária
                        t = t_final - t_inicial;
                        System.out.println("\nO tempo de execução foi de " + t + " x 10^-9 segundos");
                    break;

                default:
                    System.out.println("\nDIGITE UM VALOR VÁLIDO");
                    break;
            }
        } while (escolha != 3);
    }
}

package projeto_4;

import java.util.Scanner;

public class Projeto_4 {

    public static void main(String[] args) {

        Cubo cubo = new Cubo();
        Esfera esfera = new Esfera();
        Paralelopipedo para = new Paralelopipedo();

        Scanner leitura = new Scanner(System.in);
        int escolha;
        do {
            System.out.println(" Cálculo de Áreas e Volume");
            System.out.println("|1 - Cubo");
            System.out.println("|2 - Esfera");
            System.out.println("|3 - Paralelopípedo");
            System.out.println("|4 - Sair|");
            System.out.printf("\nEscolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Defina o valor da aresta: ");
                    cubo.setAresta(leitura.nextDouble());
                    System.out.println("A Área do Cubo é " + cubo.area());
                    System.out.println("O Volume do Cubo é " + cubo.volume());
                    break;

                case 2:
                    System.out.println("Defina o valor do raio: ");
                    esfera.setRaio(leitura.nextDouble());
                    System.out.println("A Área da Esfera é " + esfera.area());
                    System.out.println("O Volume da Esfera é " + esfera.volume());
                    break;

                case 3:
                    System.out.println("Defina o valor do comprimento: ");
                    para.setComprimento(leitura.nextDouble());
                    System.out.println("Defina o valor da largura: ");
                    para.setLargura(leitura.nextDouble());
                    System.out.println("Defina o valor da altura: ");
                    para.setAltura(leitura.nextDouble());
                    System.out.println("A Área do Paralelopípedo é " + para.area());
                    System.out.println("O Volume do Paralelopípedo é " + para.volume());
                    break;
            }

        } while (escolha != 4);
    }
}

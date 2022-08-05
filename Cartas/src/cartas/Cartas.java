package cartas;

import java.util.Scanner;

public class Cartas {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        int[] baralho = new int[52];
        String[] naipe = {"Espadas", "Copas", "Paus", "Ouros"};
        String[] elementos = {"ÁS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "J", "K"};

        for (int i = 0; i < baralho.length; i++) {
            baralho[i] = i;
        }

        for (int i = 0; i < baralho.length; i++) {
            int index = (int) (Math.random() * baralho.length);
            int temp = baralho[i];
            baralho[i] = baralho[index];
            baralho[index] = temp;
        }

        System.out.println("Quantas cartas deseja para o seu baralho?");
        int n = leitura.nextInt();
        for (int i = 0; i < n; i++) {
            String naipes = naipe[baralho[i] / 13];
            String elements = elementos[baralho[i] % 13];
            System.out.println(elements + " de " + naipes);
        }
    }
}

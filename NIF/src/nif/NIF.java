/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nif;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class NIF {
    public static void verifyID(String id) {
        char letter;
        int id_nmr = 0, soma = 0;
        boolean secondDigit = false;
        //REMOVER ESPAÇOS EM BRANCO
        id = id.replaceAll("\\s+", "");
        if (id.length() == 12) {

            for (int i = id.length() - 1; i >= 0; --i) {
                //CONVERTER A STRING EM CARACTERES
                letter = id.charAt(i);
                //PARA CADA CARACTER ATRIBUIR UM VALOR INTEIRO
                id_nmr = Character.getNumericValue(letter);
                if (secondDigit) {
                    id_nmr *= 2;
                    if (id_nmr > 9) {
                        id_nmr -= 9;
                    }
                }
                soma += id_nmr;
                secondDigit = !secondDigit;
            }
            if (soma % 10 == 0) {
                System.out.println("O número de id civil que introduziu é válido");
            } else {
                System.out.println("O número de id civil que introduziu não é válido");
            }
        } else {
            System.out.println("O número de id civil que introduziu não contém os 12 digitos");
        }
    }

    public static void verifyNIF(int nif) {
        int digito = 0, contador = 0, total = 0, aux = nif, n_elemento = 1, rest_div, check_digit, last;

        //CONTAR DIGITOS DO NIF
        while (aux != 0) {
            contador += 1;
            aux = aux / 10;
        }

        //SE O NIF TIVER OS 9 DIGITOS VERIFICAR OS 9 ELEMENTOS
        if (contador == 9) {
            //ULTIMO DIGITO DO NIF
            last = nif % 10;
            //NIF SEM O ULTIMO DIGITO
            nif /= 10;

            while (nif != 0) {
                digito = nif % 10;
                n_elemento += 1;
                total += n_elemento * digito;
                nif /= 10;
            }
            //CALCULAR RESTO DA DIVISÃO
            rest_div = total % 11;

            if (rest_div < 2) {
                check_digit = rest_div;
            } else {
                check_digit = 11 - rest_div;
            }

            if (check_digit == last) {
                System.out.println("O número de contribuinte é válido");
            } else {
                System.out.println("O número de contribuinte não é válido");
            }

        } else {
            System.out.print("O NIF que introduziu não contém os 9 digitos ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leitura = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("1- Introduzir o ID Civil");
            System.out.println("2- Introduzir o NIF");
            System.out.println("3- Sair do Programa");
            System.out.printf("Escolha uma das opções: ");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    String id;
                    System.out.printf("Insira o seu ID Civil: ");
                    leitura.nextLine();
                    id = leitura.nextLine().toUpperCase();
                    System.out.printf(id);
                    verifyID(id);
                    break;
                case 2:
                    int nif;
                    System.out.printf("Insira o seu NIF: ");
                    nif = leitura.nextInt();
                    verifyNIF(nif);
                    break;
                default:
                    System.out.printf("Saiu do Programa");
                    break;
            }
        } while (escolha != 3);

    }

}

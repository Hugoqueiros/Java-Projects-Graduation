package treemapimplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
import java.util.concurrent.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TreeMapImplementation {

    public boolean letras(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean espacos(char ch) {
        if (ch == ' ') {
            return true;
        } else {
            return false;
        }
    }

    // Driver code 
    public static void main(String[] args) throws IOException {

        int letras = 0, espacos = 0, sinais = 0, carateres, contagem = 1, escolha, value = 0;
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Scanner leitura = new Scanner(System.in);
        String palavra = "";
        do {
            System.out.println("\n1- Inserir Palavra");
            System.out.println("2- Visualizar a quantidade de vezes que ocorre o nome e o total de palavras");
            System.out.println("3- Abrir Ficheiro para contagem");
            System.out.println("4- Sair");
            System.out.printf("Escolha uma das opções: \n");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    leitura.nextLine();
                    System.out.printf("Digite a palavra: ");
                    palavra = leitura.nextLine();
                    if (map.containsKey(palavra)) {
                        contagem = map.get(palavra) + 1;
                        map.put(palavra, contagem);
                        System.out.println(map.get(palavra));
                    }
                    map.put(palavra, contagem);
                    break;

                case 2:
                    for (Map.Entry<String, Integer> e : map.entrySet()) {
                        System.out.println("A palavra " + e.getKey() + " ocorre " + e.getValue());
                    }
                    for (Map.Entry<String, Integer> e : map.entrySet()) {
                        value = value + e.getValue();
                    }
                    for (int i = 0; i < palavra.length(); i++) {
                        if (palavra.charAt(i) != ' ') {
                            letras++;
                        }
                    }
                    System.out.println("O ficheiro tem de um total de " + value + " palavras (" + map.size() + " palavras diferentes) e de " + letras + " caracteres");
                    break;

                case 3:
                    File ficheiro = new File("ficheiro.txt");
                    String frase = "Com o tempo, os engenheiros informáticos tiram partido do trabalho uns dos outros e inventam algoritmos para novas coisas. Algoritmos combinam-se com outros algoritmos para utilizar os resultados de outros algoritmos, por sua vez produzindo resultados para ainda mais algoritmos. A cada segundo, milhares de milhões de transístores em milhares de milhões de computadores ligam-se milhares de milhões de vezes. Os algoritmos formam uma nova espécie de ecossistema - em crescimento constante, de uma riqueza apenas comparável à da própria vida.";
                    frase = frase.toLowerCase().replaceAll("[.,!]", "");
                    String texto;
                    BufferedWriter escrita = new BufferedWriter(new FileWriter(ficheiro));
                    escrita.write(frase);
                    escrita.close();
                    BufferedReader objReader = new BufferedReader(new FileReader("ficheiro.txt"));
                    Scanner ler = new Scanner(new File("ficheiro.txt"));
                    while (ler.hasNext()) {
                        String word = ler.next();
                        Integer count = map.get(word);
                        count = (count == null ? 1 : count + 1);
                        map.put(word, count);
                    }
                    for (Map.Entry<String, Integer> e : map.entrySet()) {
                        System.out.println("A palavra " + e.getKey() + " ocorre " + e.getValue() + " vezes.");
                    }
                    ler.close();
                    break;
            }
        } while (escolha != 4);
    }
}

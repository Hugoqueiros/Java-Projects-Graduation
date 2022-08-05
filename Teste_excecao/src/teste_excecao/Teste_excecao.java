package teste_excecao;

import java.util.Scanner;

public class Teste_excecao {

    public static void main(String[] args) {
        boolean inputOK = false;

        Scanner leitura = new Scanner(System.in);
        do {
            try {
                String nome = leitura.nextLine();

                if (nome.equals("")) {
                    throw new InvalidNumberException();
                }
                inputOK = true;
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
                leitura.reset();
            }
        } while (!inputOK);
    }

}

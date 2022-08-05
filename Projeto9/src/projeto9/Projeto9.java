
package projeto9;


public class Projeto9 {


    public static void main(String[] args) {

        ContaOrdem c1 = new ContaOrdem("Hugo", 1500,100);
        ContaOrdem c2 = new ContaOrdem("Queirós", 1000,200);

        if (c1.Limite_verificacao(c2) == true) {
            System.out.println("O crédito do 1º cartão é superior ao crédito do 2º cartão");
        } else {
            System.out.println("O crédito do 2º cartão é superior ao crédito do 1º cartão");
        }
        ContaPrazo c3 = new ContaPrazo("Hugo Queirós", 1500);
        c3.saldoposJuros();
        c3.print();

    }

}

    


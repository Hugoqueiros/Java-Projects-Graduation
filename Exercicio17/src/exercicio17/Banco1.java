
package exercicio17;

import java.util.Scanner;


public class Banco1 {
        
    public static void main(String[] args) {
        
        Scanner leitura = new Scanner(System.in);
        int escolha;
        int depositar, levantar;
        ContaBancaria c1 = new ContaBancaria ("Hugo", 1000);
        c1.print();
         do {
            System.out.println("1- Depositar dinheiro");
            System.out.println("2- Levantar Dinheiro");
            System.out.println("3- Sair");
            System.out.printf("Escolha uma opção:");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1 :
                    System.out.println("Qual a quantia que deseja depositar: ");
                    depositar= leitura.nextInt();
                    c1.depositardinheiro(depositar + c1.getSaldoCartao());
                    c1.print();
                    break;
                    
                case 2:
                    System.out.println("Qual a quantia que deseja levantar: ");
                    levantar= leitura.nextInt();
                    if (levantar > c1.getSaldoCartao())
                        System.out.println("Não é possível efetuar levantamentos na conta");
                    else
                        c1.depositardinheiro(c1.getSaldoCartao()- levantar);
                        c1.print();
                        break;
            }
       
        } while (escolha != 3);
         System.out.println("Obrigado pela sua visita");
         
        ContaBancaria c2 = new ContaBancaria ("António", 500);
        c2.print();

}
    
}


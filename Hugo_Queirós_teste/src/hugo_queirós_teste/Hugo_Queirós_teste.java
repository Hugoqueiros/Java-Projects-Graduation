/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugo_queirós_teste;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Hugo_Queirós_teste {
    

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);    
        
        double salario = -1, salarioapos;
        char escolha;
        boolean salarioa = false;

        do {
            System.out.println("(I) Inserir o valor do salário atual: ");
            System.out.println("(A) Novo salário da categoria A: ");
            System.out.println("(B) Novo salário da categoria B");
            System.out.println("(C) Novo salário da categoria C:");
            System.out.println("(D) Novo salário da categoria D");
            System.out.println("(E) Novo salário da categoria E");
            System.out.println("(S) Sair");
            System.out.printf("Escolha uma opção:");
            escolha = leitura.next().charAt(0);
            switch (escolha) {
                case 'I' :
                    do {
                        System.out.printf("Insira o seu salário: ");
                        salario = leitura.nextDouble();
                        if (salario < 0) {
                            System.out.println("Erro ");
                        }
                    } while (salario < 0);

                    salarioa = true;
                    break;
                case 'A':
                    if (salarioa == true) {
                        if (salario <= 2000){
                            salarioapos= (salario*0.01) + salario;
                            System.out.println("O salário após o aumento é " + salarioapos + "€");
        }
        else{
            System.out.println("O seu salário permanece o mesmo");
        }
                    }
                    break;
                case 'B':
                    if (salarioa == true) {
                         if (salario <= 2000){
                            salarioapos= (salario*0.015) + salario;
                            System.out.println("O salário após o aumento é " + salarioapos + "€");
        }
        else{
            System.out.println("O seu salário permanece o mesmo");
        }
                    }
                    break;
                case 'C':
                    if (salarioa == true) {
                        if (salario <= 2000){
                            salarioapos= (salario*0.017) + salario;
                            System.out.println("O salário após o aumento é " + salarioapos + "€");
        }
        else{
            System.out.println("O seu salário permanece o mesmo");
        }
                    }
                    break;
                    
                case 'D':
                    if (salarioa == true) {
                        if (salario <= 2000){
                            salarioapos= (salario*0.02) + salario;
                                System.out.println("O salário após o aumento é " + salarioapos + "€");
        }
        else{
            System.out.println("O seu salário permanece o mesmo");
        }
                    }
                    break;
                    
                
                case 'E':
                    if (salarioa == true) {
                       if (salario <= 2000){
                            salarioapos= (salario*0.0225) + salario;
                            System.out.println("O salário após o aumento é " + salarioapos + "€");
        }
        else{
            System.out.println("O seu salário permanece o mesmo");
        }
                    }
                    break;
                    
                
                default:
                    System.out.println("Saiu do programa");
                    break;
            }
        } while (escolha != 'S');

    }
}
        

        

    


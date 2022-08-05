/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartao_cidadao;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class Cartao_cidadao {
    
    public static void main(String[] args) {
        
        Scanner leia = new Scanner( System.in );

        
        int num, a, b, c, d, e, f, g, h, j, passo1, passo2, passo3, contador=0;
        String IC;
        System.out.println("Insira o número de Identificação civil: ");
        IC = leia.nextLine().toUpperCase();
        int numero_IC = 0, soma = 0;
        char letter;
        boolean secondDigit = false;
        IC = IC.replaceAll("\\s+", "");
        if (IC.length() == 12) {

            for (int i = IC.length() - 1; i >= 0; --i) {
                letter = IC.charAt(i);
                numero_IC = Character.getNumericValue(letter);
                if (secondDigit) {
                    numero_IC *= 2;
                    if (numero_IC > 9) {
                        numero_IC -= 9;
                    }
                }
                soma += numero_IC;
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
    
        
        System.out.println("Insira o número de contribuinte: ");
        num = leia.nextInt();
        
        while(num>0){
          num=num/10;
          contador= contador+1;
         
      }
        if (contador==9){
        a= num / 1%10;
        b= num / 10%10;
        c= num / 100%10;
        d= num / 1000%10;
        e= num / 10000%10;
        f= num / 100000%10;
        g= num / 1000000%10;
        h= num / 10000000%10;
        j= num / 100000000%10;
        
        passo1= 9 * j + 8 * h + 7 * g + 6 * f + 5 * e + 4 * d + 3 * c + 2 * b;
        passo2= passo1 % 11;
        if (passo2>2){
            passo3= 11- passo2;
            if(a==passo3){
                System.out.println("Numero de contribuinte válido");
            }
            else{
                System.out.println("Numero de contribuinte Inválido");
            }
        }
        
        else{
            if(a==passo2){
                System.out.println("Número de contribuinte válido");
            }
            else{
                System.out.println("Número de contribuinte inválido");
            }
                    
                    }
        
        
        }
        else{
            System.out.println("Não contém 9 dígitos o Nº Contribuinte! ");
        }
    
    
    }  
    }
         


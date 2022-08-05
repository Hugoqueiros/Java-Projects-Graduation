/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetores;
import java.util.Scanner;


/**
 *
 * @author hugo-
 */
public class Vetores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Scanner leia = new Scanner (System.in);

            int v[]  = new int [10]; // Vetor já com valores preenchidos.
            int soma = 0; // inicia variavel soma com 0.
            double media,maior;
            maior=0;
            int n;
            int contador = 0;
            
        for (int i =0 ; i<10; i++){
            System.out.println("Digite o valor para o numero do vetor: " + v[i] );
            v[i]= leia.nextInt();
            soma = soma +  v[i]; // soma a variavel soma com cada valor dos indices do vetor. 
            maior=v[0];
            if (v[i]> maior){
                maior = v[i];
            if (v[i]%2==0)
               System.out.println("É numero par");
            }
            
            
         
           
            
                   
            }

            media= soma / 10.0;
            

            System.out.println("Total: "+soma); 
            System.out.println( "A média é de " + media);
            System.out.println("O maior é "+ maior);
            System.out.println("Número de Ocorrências: ");
            System.out.println("Valor a procurar: ");
            n= leia.nextInt();
                for(int i=0;i<10;i++){
                    if(v[i]==n){
                        contador+=1;
                    }
                }
                    System.out.println("O número " + n + " está escrito em " + contador + " posições");
                    
        }
     }



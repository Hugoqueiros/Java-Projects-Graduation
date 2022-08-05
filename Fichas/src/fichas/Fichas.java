/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichas;
import java.util.Scanner;
/**
 *
 * @author hugo-
 */
public class Fichas {

    /**
     * @param args the command line arguments
     */
    public static void ordena(int v[]){  
        // TODO code application logic here
   int cont1, cont2,aux;  
         for(cont1 =0; cont1<15; cont1++){  
             for(cont2 =0; cont2 <14; cont2++){  
                if(v[cont2]> v[cont2+1]){  
                     aux = v[cont2];  
                     v[cont2] = v[cont2+1];  
                     v[cont2+1] = aux;  
                 }  
             }  
         }              
}      
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner vet = new Scanner (System.in);
        int[] v = new int[15];        
        System.out.println("Leitura de elementos:");
        for( int i=0; i<v.length; i++){
            System.out.print("Elemento " + i + ": ");
            v[i] = vet.nextInt();
        }
        ordena(v);
     
     System.out.println("Numeros Ordenados: ");
     for (int numero :v){
         System.out.println(numero);
     }
        
    }
}
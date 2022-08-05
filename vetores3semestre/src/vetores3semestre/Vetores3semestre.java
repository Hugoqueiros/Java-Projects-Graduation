
package vetores3semestre;
import java.util.Scanner;


public class Vetores3semestre {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int x, a = 0,maior=-999999999,menor=999999999,nr;
        int v[] = new int[a];
        do {
            System.out.println("Menu de Opções");
            System.out.println("1- Introduzir a dimensão dos vetores?");
            System.out.println("2- Ler os elementos do vetor");
            System.out.println("3- Escrever todos os elementos do vetor");
            System.out.println("4- Escrever todos os elementos do vetor por ordem inversa");
            System.out.println("5- Pesquisar a existência de um elemento");
            System.out.println("6- Encontrar o maior elemento");
            System.out.println("7- Encontrar o menor elemento");
            System.out.println("8- Acrescentar um elemento ao vetor existente");
            System.out.println("9- Sair");
            System.out.print("O que pretende fazer? ");
            x = leia.nextInt();
            switch (x) {

                case 1:
                    System.out.print("Quantos elementos pretende? ");
                    a = leia.nextInt();
                    v = new int[a];
                    break;

                case 2:

                    System.out.println("Leitura de elementos:");
                    for (int i = 0; i < a; i++) {
                        System.out.print("Elemento " + (i+1) + ": ");
                        v[i] = leia.nextInt();
                    }
                break;
                    
                case 3:
                    for (int i = 0; i<a; i++){
                        System.out.println(v[i]);
                    }
                break;
                
                
                case 4:
                    for (int i = a-1; i>=0; i--) {
                        System.out.println(v[i]);
                    }
                break;
                
                
                case 5:
                    System.out.print("Qual é o número? ");
                    nr=leia.nextInt();
                    for(int i=0; i<a;i++){
                        if(v[i]==nr){
                            System.out.println("O número "+nr+" encontra-se na posição "+i);
                            break;
                        }
                        else{
                            System.out.println("O número "+nr+" não se encontra no vetor");
                        }
                    }
                break;
                
                
                case 6:
                    for(int i=0;i<a;i++){
                        if(v[i]>maior){
                            maior=v[i];
                        }
                    }
                    System.out.println("O maior número é: "+maior);
                break;
                
                
                case 7:
                    for(int i=0;i<a;i++){
                        if(v[i]<menor){
                            menor=v[i];
                        }
                    }
                    System.out.println("O menor número é: "+menor);
                break;
                
                
                case 8:
                    
                break;
                
                
            } 
            } while (x != 9 || (x >= 1 && x <= 8));

        }
}
    



package pessoa;
import java.util.Scanner;



public class Pessoa {
        
    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
        int opcao;
        boolean vetorPreenchido = false;
        Pessoa []v= new Pessoa[3];
        
        do{
            System.out.println("1- Inserir Pessoas");
            System.out.println("2- Lista Pessoas");
            System.out.println("3- Alterar Pessoas");
            System.out.println("4- Mudar Nacionalidade");
            System.out.println("5- Comparar Idades");
            System.out.println("6- Sair");
            opcao=leia.nextInt();
            
            switch(opcao){
                case 1:
                    vetorPreenchido = true;
                    for (int i=0; i<v.length; i++){
                        System.out.println("Insira a pessoa " +(i+1));
                        v[i]= new Pessoa();
                        leia.nextLine();
                        System.out.println("Nome: ");
                        v[i].setNome(leia.nextLine());
                        System.out.println("Morada: ");
                        v[i].setMorada(leia.nextLine());
                        System.out.println("Idade: ");
                        v[i].setIdade(leia.nextInt());
                        System.out.println("NIC: ");
                        v[i].setId(leia.nextInt());
                    }
            }
            

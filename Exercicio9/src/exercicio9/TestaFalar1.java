
package exercicio9;
import java.util.Scanner;


public class TestaFalar1 {
    public static void main(String[] args) {
        
        Scanner leitura = new Scanner(System.in);
        System.out.println("Insira uma frase: ");
        String frase =leitura.nextLine();
        System.out.println("Escolha uma das opções seguintes");
        System.out.println("A-Inserir Aluno");
        System.out.println("P-Inserir Professor");
        String escolha=leitura.nextLine().toUpperCase();
        char letra = escolha.charAt(0);
        switch(letra){
            
            case 'A':
                Aluno a1= new Aluno ( "Pedro Martins",'M', 15 ,"A",23);
                a1.print();
                a1.falar(frase);
                Aluno a2= new Aluno();
                System.out.printf("Insira o nome pretendido: ");
                leitura.nextLine();
                System.out.printf("Género:");
                leitura.nextLine();
                System.out.printf("Idade: ");
                leitura.nextLine();
                break;
                
            case 'P':
                Professor p1= new Professor ("Helena Lopes", 'F', 40, "550", "2");
                p1.print();
                p1.falar(frase);
                Professor p2= new Professor ();
                System.out.printf("Insira o nome pretendido: ");
                leitura.nextLine();
                System.out.printf("Género:");
                leitura.nextLine();
                System.out.printf("Idade: ");
                leitura.nextLine();
                break;
                
        }
                
        }
    
}

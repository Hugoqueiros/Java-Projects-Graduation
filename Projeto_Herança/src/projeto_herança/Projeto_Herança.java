
package projeto_herança;

public class Projeto_Herança {

    public static void main(String[] args) {
        
        Definicao aluno1 = new Definicao("Aluno", "Ispgaya", 103225);
        
        Aluno aluno2 = new Aluno( "Aluno", "IspGaya", 2019103226, "EI", 2 );
        
        aluno1.print();
          
        System.out.println("");
        
        aluno2.print();
    }
    
}

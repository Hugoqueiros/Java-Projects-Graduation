
package exercicio9;


public class Professor extends Pessoa {
    private String docencia;
    private String escalao;
    public Professor(){
        docencia = "";
        escalao = "";
    }

 

    public Professor(String nome, char genero, int idade, String docencia, String escalao) {
        super(nome, genero, idade);
        this.docencia= docencia;
        this.escalao= escalao;
    }

 

    public String getGrupoDeDocencia() {
        return docencia;
    }

 

    public String getEscalaoDoProf() {
        return escalao;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("\nGrupo de Docencia: " + docencia + "\nEscalao: "+ escalao);
}
     @Override
     public void falar(String frase){
          super.falar(frase);
            System.out.println( "e sou um professor.");
         
      }
      

      
    
}
 
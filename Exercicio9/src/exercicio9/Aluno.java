package exercicio9;

 

public class Aluno extends Pessoa {
    private String turma;
    private int numero;
    
    public Aluno(){
    
        turma= "";
        numero=0;
}
    
      public Aluno(String nome, char genero, int idade ,String turma, int numero){
          super(nome,genero,idade);
          this.turma = turma;
          this.numero = numero;
      }

 

    public String getTurma() {
        return turma;
    }

 

    public int getNumero() {
        return numero;
    }
    
    @Override
    public void print(){
        super.print();
        System.out.println("Numero do Aluno: " + numero + "\nTurma: "+ turma);
}


    @Override
    public void falar(String frase){
          super.falar(frase);
            System.out.println( "e sou um aluno.");
        
      }

    
     
}

package exercicio9;




public class Pessoa {
      private String nome;

      private char genero;

      private int idade;

      public Pessoa(){
          nome="";
          genero= 'A';
          idade = 0;

      }

      public Pessoa( String nome, char genero, int idade ){

            this.nome = nome;

            this.genero = genero;

            this.idade = idade;

      }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public char getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }
      

    public void falar(String frase){

            System.out.println( frase );

      }
      
      
    public void print(){
        
        System.out.println("Nome: " + nome + "\nGenero: "+ genero + "\nIdade: "+ idade);
}

}


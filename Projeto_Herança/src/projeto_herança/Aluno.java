
package projeto_herança;

public class Aluno extends Definicao {
    
    private String curso;
    private int ano;
  
    public Aluno() {
        this( "", "", 0, "", 0);
    }
    
    public Aluno(String estatuto, String universidade,int numero, String curso, int ano) {
        super( estatuto, universidade, numero );
        this.curso = curso;
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

   
    
    @Override
    public String toString(){
        return "" + curso + ", " + ano + "\n";
    }
     
    @Override
    public void print(){
        super.print();
        System.out.println("Curso: " + curso );
        System.out.println("Ano:" + ano);
    }
}

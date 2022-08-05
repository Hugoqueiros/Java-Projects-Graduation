
package hashmap;


public class Aluno {
    
    int aluno_id, classificacao;
    String nome, curso;
    
    public Aluno(){
        
    }

    public Aluno(int aluno_id, String nome, String curso, int nota) {
        this.classificacao = classificacao;
        this.nome = nome;
        this.curso = curso;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    

    @Override
    public String toString() {
        return ", nome= " + nome + ", curso= " + curso +", classificacao=" + classificacao + "}";
    }

    
}

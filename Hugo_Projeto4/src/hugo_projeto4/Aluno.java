package hugo_projeto4;

public class Aluno {
        int nota;
        String nome, id_aluno;
        String curso;
    
    public Aluno(){   
    }
    
    public Aluno (String id_aluno, String nome, String curso, int nota){
        this.nome=nome;
        this.curso=curso;
        this.nota=nota; 
    }
    
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return "Aluno{" + "nota=" + nota + ", nomeAluno=" + nome + ", NumAluno=" + id_aluno + ", curso=" + curso + '}';
    }
}
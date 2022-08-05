
package pessoa;



public class testa_pessoa {
    private String nome;
    private String morada;
    private int idade;
    private String id;
    private String nacionalidade;
    public testa_pessoa(){ 
        
    }
    public testa_pessoa(String nome, String morada, int idade, String id){
        this.nome = nome;
        this.morada = morada;
        this.idade = idade;
        this.id = id;
        this.nacionalidade = nacionalidade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

 

    public String getMorada() {
        return morada;
    }

 

    public void setMorada(String morada) {
        this.morada = morada;
    }

 

    public int getIdade() {
        return idade;
    }

 

    public void setIdade(int idade) {
        if(idade>=0 && idade <= 100)
            this.idade = idade;
        else
            System.out.println("Idade inválida");
    }

 

    public String getId() {
        return id;
    }
    
    public String getNacionalidade() {
       return nacionalidade;
    }

 

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


 

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return ""+nome+", "+morada+", "+idade+", "+id+"\n";
    } 
    public void print(){
        System.out.println("Nome:" + nome);
        System.out.println("Morada:" + morada);
        System.out.println("Idade:" + idade);
        System.out.println("Identificação civil: " + id);
        System.out.println("Nacionalidade: " + nacionalidade);
    }
}




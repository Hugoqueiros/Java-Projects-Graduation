package addressbookdemo;

public class Excecao extends Exception{
    
    public Excecao(){
        super("Dados Inseridos Inválidos");
    }
    
    public Excecao(String mensagem){
        super(mensagem);
    }
}

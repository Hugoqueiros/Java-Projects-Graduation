package teste_excecao;

public class InvalidNumberException extends Exception {
    
    public InvalidNumberException(){
        super("Número Inválido");
    }
    
    public InvalidNumberException(String mensagem){
        super(mensagem);
    }
    
}

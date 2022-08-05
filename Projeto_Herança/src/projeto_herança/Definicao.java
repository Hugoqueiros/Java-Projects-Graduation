
package projeto_herança;


public class Definicao {
    private String estatuto;
    private String universidade;
    private int numero;
  
    public Definicao() {
        this("", "", 0);
    }
    
    public Definicao(String estatuto, String universidade,int numero) {
        this.estatuto = estatuto;
        this.universidade = universidade;
        this.numero = numero;
    }

    public String getEstatuto() {
        return estatuto;
    }

    public void setEstatuto(String estatuto) {
        this.estatuto = estatuto;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return "" + estatuto + ", " + universidade + ", " + numero + "\n";
    } 
    
    public void print(){
        System.out.println("Estatuto: " + estatuto );
        System.out.println("Universidade: " + universidade );
        System.out.println("Número: " + numero );
    }
}

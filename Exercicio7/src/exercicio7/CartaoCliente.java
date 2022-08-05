
package exercicio7;

public class CartaoCliente {
    private int cartaoCliente;
    private String titularDoCartao;
    private double pontosDoCartao;
    
    public CartaoCliente() {
    cartaoCliente = 0;
    titularDoCartao = "";
    pontosDoCartao = 0;
}
    public CartaoCliente(int cartaoCliente, String titularDoCartao){
        this.cartaoCliente = cartaoCliente;
        this.titularDoCartao = titularDoCartao;
    }
    
     public void Creditarpontos(double pontosDoCartao) {
        this.pontosDoCartao = pontosDoCartao;
    }
    
     public void Debitarpontos(double pontosDoCartao) {
        this.pontosDoCartao = pontosDoCartao;
    }

 

    public double getCartaoCliente() {
        return cartaoCliente;
    }

 

    public void setCartaoCliente(int cartaoCliente) {
        this.cartaoCliente = cartaoCliente;
    }

 

    public String getTitularDoCartao() {
        return titularDoCartao;
    }

 

    public void setTitularDoCartao(String titularDoCartao) {
        this.titularDoCartao = titularDoCartao;
    }

 

    public double getPontosDoCartao() {
        return pontosDoCartao;
    }

 

    public void setPontosDoCartao(double pontosDoCartao) {
        this.pontosDoCartao = pontosDoCartao;
    }
    
    public void setTransferepontos(CartaoCliente c) {
        this.pontosDoCartao += c.pontosDoCartao;
        c.pontosDoCartao = 0;
    }

 

    @Override
    public String toString() {
        return "CartaoCliente{" + "cartaoCliente=" + cartaoCliente + ", titularDoCartao=" + titularDoCartao + ", pontosDoCartao=" + pontosDoCartao + '}';
    }
    public void print(){
        System.out.println("Nº Cartão: " + cartaoCliente);
        System.out.println("Nome do Titular: " + titularDoCartao);
        System.out.println("Pontos Do Cartão: " + pontosDoCartao);
        
}
}


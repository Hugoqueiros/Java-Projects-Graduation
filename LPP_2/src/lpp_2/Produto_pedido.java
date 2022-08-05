package lpp_2;

public class Produto_pedido {

    private int quantidade;
    private Double preco;

    private Produto product;

    public Produto_pedido() {
    }

    public Produto_pedido(int quantidade, Double preco, Produto product) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.product = product;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduct() {
        return product;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public double subTotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return "Nome do Produto: " + getProduct().getNome() + ", Preço do Produto: " + String.format("%.2f", preco) + "€, Quantidade do Produto Pedido: " + quantidade + "\nSubtotal do Produto: " + String.format("%.2f", subTotal()) + "€";
    }
}
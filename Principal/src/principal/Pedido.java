package principal;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private Cliente cliente;
    

    private List<Produto_pedido> items = new ArrayList<Produto_pedido>();

    public Pedido() {
    }

    public Pedido(Cliente client) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(Produto_pedido item) {
        items.add(item);
    }

    public void removeItem(Produto_pedido item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for (Produto_pedido it : items) {
            sum += it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (Produto_pedido item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}

package lpp_2;

import java.util.ArrayList;
import java.util.List;

public class Encomenda {

    private List<Produto_pedido> itens = new ArrayList<Produto_pedido>();
    private Cliente cliente;

    public Encomenda() {
    }
    
    public Encomenda(Cliente client) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionar_pro(Produto_pedido item) {
        itens.add(item);
    }

    public void retirar_pro(Produto_pedido item) {
        itens.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for (Produto_pedido it : itens) {
            sum += it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda: \n");
        for (Produto_pedido item : itens) {
            sb.append(item + "\n");
        }
        sb.append("Total a Pagar: " + String.format("%.2f", total()) + "€");
        return sb.toString();
    }
}

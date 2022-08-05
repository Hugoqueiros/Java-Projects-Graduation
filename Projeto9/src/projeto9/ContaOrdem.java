
package projeto9;



public class ContaOrdem extends ContaBancaria{

    private int limite_credito;

    public ContaOrdem() {
        limite_credito = -100;
    }

    public ContaOrdem(String titular_conta, double saldo_conta, int limite_credito) {
        super(titular_conta, saldo_conta);
        this.limite_credito = limite_credito;
    }

    public boolean Limite_verificacao(ContaOrdem c) {
        if (this.limite_credito > c.limite_credito) 
            return true;
        else 
            return false;
        
    }

    @Override
    public String toString() {
        return "Limite de Crédito=" + limite_credito + '}';
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Limite de crédito: ");
    }
}
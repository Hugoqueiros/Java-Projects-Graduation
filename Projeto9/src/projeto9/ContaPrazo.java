
package projeto9;


public class ContaPrazo extends ContaBancaria {
    
    private double juros = 0.01;
    private int prazo= 365;
    private double saldo_apos;


    public ContaPrazo(String titular_conta, double saldoCartao) {
        super(titular_conta, saldoCartao);
    }

    public double saldoposJuros() {
        saldo_apos = super.getSaldoCartao() * juros;
        saldo_apos = super.getSaldoCartao() + saldo_apos;
        return saldo_apos;
    }

    @Override
    public String toString() {
        return "Juros=" + juros + ", Prazo=" + prazo;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Saldo após juros: " + saldo_apos);
    }
}


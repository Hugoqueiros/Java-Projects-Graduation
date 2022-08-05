package projeto_6;

public class saldo implements Interface_2 {

    private double saldo;

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor - taxa;
        System.out.println("Depositou " + valor);
        System.out.println("O seu saldo é " + this.saldo);
    }

}

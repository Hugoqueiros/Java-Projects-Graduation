package projeto_6;

public class Levantar implements Interface_1, Interface_3 {

    double saldo;

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void levantar(double valor) {
        this.saldo -= valor + taxa;
        System.out.println("Levantou " + valor + " da sua conta");
        System.out.println("O seu saldo é de " + saldo);
    }

}

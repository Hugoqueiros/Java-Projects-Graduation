
package projeto9;


public class ContaBancaria {
    
    private int numerocartao;
    private String titularDoCartao;
    private double saldoCartao;
    private int depositar;
    private int levantar;
    private static int contador;
    
    
    
    public ContaBancaria() {
    numerocartao= 0;
    titularDoCartao = "";
    saldoCartao = 0;

}
    public ContaBancaria(String titularDoCartao, double saldoCartao){
        this.titularDoCartao = titularDoCartao;
        this.saldoCartao = saldoCartao;
        contador++;
        numerocartao=contador;
    }

    

    public int getNumerocartao() {
        return numerocartao;
    }

    public void setNumerocartao(int numerocartao) {
        this.numerocartao = numerocartao;
    }

    public String getTitularDoCartao() {
        return titularDoCartao;
    }


    public double getSaldoCartao() {
        return saldoCartao;
    }

     public void depositardinheiro(double saldoCartao) {
        this.saldoCartao = saldoCartao;
    }
    
     public void levantardinheiro(double saldoCartao) {
        this.saldoCartao = saldoCartao;
    }

     public void setTransferepontos(ContaBancaria c) {
        this.saldoCartao += c.saldoCartao;
        c.saldoCartao = 0;
    }
    
    @Override
    public String toString() {
        return "Conta Bancária" + "Nº Cartão=" + numerocartao + ", TitularDoCartao=" + titularDoCartao + ", saldoDoCartao=" + saldoCartao + '}';
    }
    public void print(){
        System.out.println("Nº Cartão: " + numerocartao);
        System.out.println("Nome do Titular: " + titularDoCartao);
        System.out.println("Saldo do Cartão: " + saldoCartao);
           
}
}

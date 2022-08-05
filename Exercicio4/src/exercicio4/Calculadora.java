
package exercicio4;


public class Calculadora {
    
    private static double x;
    private static double y;
    private double soma;
    private double subtracao;
    private double divisao;
    private double multiplicacao;
    
    public Calculadora(){
        x=0;
        y=0;
        soma=0;
        subtracao=0;
        divisao=0;
        multiplicacao=0;    
    }
    public Calculadora ( double x, double y){
        this.x= x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    
    public double getSoma(double x,double y) {
        soma= x+y;  
        return soma;
    }



    public double getSubtracao(double x, double y) {
        subtracao = x - y;
        return subtracao;
    }

 

    public double getDivisao(double x, double y) {
        divisao=x/y;
        return divisao;
    }



    public double getMultiplicacao(double x, double y) {
        multiplicacao= x*y;
        return multiplicacao;
    }

    
    @Override
    public String toString(){
        return "" + x + ", " + y + " ," + soma + " ," + divisao+ " ,"+ multiplicacao;
    }
    
    public void print(){
        System.out.println("O resultado da soma é: " + soma );
        System.out.println("O resultado da subtracao é : " + subtracao  );
        System.out.println("O resultado da divisao é  : " + divisao   );       
        System.out.println("O resultado da multiplicação é: " + multiplicacao ); 
    }
    
}

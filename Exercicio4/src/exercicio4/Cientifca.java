
package exercicio4;

public class Cientifca extends Calculadora{
    
    private double potencia;
    private double raiz;


    public Cientifca(){
        potencia=0;
        raiz=0;    
    }
    
    public Cientifca(double x, double y){
        super(x,y);
}

    public void getPotencia(double x,double y) {
        potencia= Math.pow(x, y);
        System.out.println("O valor da potência é "+ potencia);
        
    }

    public void getRaiz(double x, double y) {
        raiz= Math.sqrt(x);
        System.out.println("O valor da raiz é "+ raiz);
        
    }
    
}
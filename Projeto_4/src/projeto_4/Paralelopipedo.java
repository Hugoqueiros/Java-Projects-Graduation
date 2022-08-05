package projeto_4;

public class Paralelopipedo extends Figura_geometrica {
    
    private double comprimento;
    private double largura;
    private double altura;
    
    public Paralelopipedo() {
        comprimento = 1;
        largura=1;
        altura = 1;
    }

    public Paralelopipedo(double comprimento, double largura, double altura) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double area(){
        return 2 * (largura * comprimento + largura * altura + comprimento * altura);
    }
    
    public double volume(){
        return largura * comprimento * altura;
    }
    
    
}

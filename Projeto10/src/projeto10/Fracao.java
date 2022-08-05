
package projeto10;


public class Fracao {
    
    private double numerador;
    private double denominador;
    public static boolean FormatoFraccao = true;

    public Fracao() {
        numerador = 0;
        denominador = 1;
    }

    public Fracao(double Numerador, double Denominador) {
        this.numerador = Numerador;
        this.denominador = Denominador;
    }

    public void mostraFracao() {
        if (FormatoFraccao) 
            System.out.println(numerador +"/"+ denominador);
         else 
            System.out.println(numerador / denominador);
        
    }

    public double getDenominador() {
        return denominador;
    }

    public double getNumerador() {
        return numerador;
    }

    public void setDenominador(double denominador) {
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            System.out.println("Valor inválido para o denominador!");
        }
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public static void setFormatoFraccao() {
        FormatoFraccao = true;
    }

    public static void resetFormatoFraccao() {
        FormatoFraccao = false;
    }

    public Fracao soma(Fracao f) {
        if (this.denominador != f.getDenominador()) {
            System.out.println("Os denominadores são diferentes!");
            return this;
        } 
        else 
            this.setNumerador((this.numerador + f.getNumerador()));
            return this;
        }
    }
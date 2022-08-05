
package almeida;


public class Almeida {

    public static void main(String[] args) {
        subalmeida pr = new subalmeida();
        String exp = ("2 * x + y"); 
        //String exp = ("num1 / (num2 + num3) * 100"); 
        //String exp = ("a - 2.5 * b + 3.6 / c"); 
        String blank = exp.replaceAll("//s","");
        String parenteses = blank.replaceAll("[()]","");
        String[] separarOsOperadores = parenteses.split("[-+/*]");
        pr.push("1211");
        pr.push("blala");
        pr.pop();
        pr.exibicaoPilha();
        System.out.println("Inversa: "+ new StringBuilder(exp).reverse().toString());
       
    }
    }

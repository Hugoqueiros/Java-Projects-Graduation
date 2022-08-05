/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras.geometricas;
import java.util.Scanner;

/**
 *
 * @author hugo-
 */
public class FigurasGeometricas {
    public static double areaCirculo (double raio){
        return Math.PI * Math.pow(raio, (2));   
    }
    public static double areaRetangulo (double l, double c){
        return c*l;
    }
    public static double areaTriangulo (double c, double a){
        return (c*a)/2;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner (System.in );
        double r, c, l, a;
        double areac, arear, areat;
        int figura;
        
        do{
            System.out.println("Indique a figura geometrica:");
            System.out.println("Circulo (1);");
            System.out.println("Retangulo (2);");
            System.out.println("Triangulo (3);");
            figura = leia.nextInt();
            switch (figura){
                case 1:
                    System.out.printf("Insira o valor para o raio: ");
                    r= leia.nextDouble();
                    areac= areaCirculo(r);
                    System.out.printf("A área é %.2f\n " , areac);
                    break;
                case 2:
                    System.out.printf("Insira o valor para o comprimento: ");
                    c = leia.nextDouble();
                    System.out.printf("Insira o valor para o largura: ");
                    l = leia.nextDouble();
                    arear = areaRetangulo(l,c);
                    System.out.printf("A area é igual a %.2f\n " , arear);
                    break;
                case 3:
                    System.out.printf("Insira o valor para o comprimento: ");
                    c = leia.nextDouble();
                    System.out.printf("Insira o valor para o altura: ");
                    a = leia.nextDouble();
                    areat = areaTriangulo (c, a);
                    System.out.printf("A área do triangulo é %.2f\n ", areat );
                    break;
                
                default:
                    System.out.println("Opção Inválida");
                    break;
                    
                         
        }
        } while (figura!=4);
        }
    
    }


package fila;


public class subclasseFila {

    public static void main(String[] args) {
        Fila fila1= new Fila();
        
        fila1.add(1);
        fila1.add(2);
        fila1.add(3);
        fila1.add(4);
        fila1.add(5);
        fila1.imprimir();
        fila1.remove();
        fila1.imprimir();
        fila1.poll();
        fila1.imprimir();
        fila1.peek();
        fila1.imprimir();
    }
}
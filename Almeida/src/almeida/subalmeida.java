
package almeida;


public class subalmeida {
    private int size;
    private String stack[];
    private String valor = "";
    private int first, last;

    public subalmeida(){
        size = 100;
        last = 0;
        first = 0;
        stack = new String[size];

    }

    public boolean isFull() {
        if (size == last) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (first == 0 && last == 0) {
            return true;
        } else {
            return false;
        }

    }

    public void push(String num) {
        if (!isFull()) {
            num = stack[first];
            first++;

        } else {
            System.out.println("A pilha está cheia");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            valor = stack[first - 1];
            if (first < size) {
                stack[first - 1] = "";
            }
            first--;
            System.out.println("Elemento retirado: " + valor);
        } else {
            System.out.println("A pilha está vazia");
        }
    }

    public void exibicaoPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia");
        }
        for (int i = last; i <= first - 1; i++) {
            System.out.println(stack[i]);
        }

    }

    public void exibicaoInversaPilha() {
        if (!isEmpty()) {
            for (int i = first; i >= last - 1; i--) {
                System.out.println(stack[i]);
            }
        } else if (isEmpty()) {
            System.out.println("A pilha está vazia");
        } else {
            System.out.println("A pilha está cheia");
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("hhh");
        } else {
            valor = stack[first - 1];
        }
        System.out.println("Primeiro elemento: " + valor);
    }
}

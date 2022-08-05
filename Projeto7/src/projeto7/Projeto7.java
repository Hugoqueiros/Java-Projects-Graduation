package projeto7;

import java.util.ArrayList;
import java.util.Iterator;

public class Projeto7 {

    public static void main(String[] args) {
        
        ArrayList<Integer> inteiros = new ArrayList<>();
        inteiros.add(1);
        inteiros.add(2);
        inteiros.add(3);
        inteiros.add(4);
        inteiros.add(5);
        inteiros.add(6);
        
        System.out.println("1- Ciclo for each");
        for(int d: inteiros){
            System.out.println(d);
        }
        
        System.out.println("\n2- Usando um Iterador ");
        for(Iterator <Integer> iter = inteiros.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }
        
        ArrayList <CaixaGenerica> caixa = new ArrayList<>();
        CaixaGenerica <Integer> caixa1 = new CaixaGenerica<>();
        caixa1.guarda(14);
        caixa.add(caixa1);
        
        System.out.println("1- Ciclo for each");
        for(CaixaGenerica i : caixa){
            System.out.println(i.consulta());
        }
        
        System.out.println("\n2- Usando um Iterador ");
        for(Iterator <CaixaGenerica> itera = caixa.iterator(); itera.hasNext();){
            System.out.println(itera.next().consulta());
        }
        
        System.out.println("Fim do uso da caixa genérica");
        
        ArrayList <Caixa> c = new ArrayList <>();
        Caixa c1 = new Caixa();
        c1.guarda("Hugo");
        c.add(c1);
        
        System.out.println("1- Ciclo for each");
        for(Caixa j : c){
            System.out.println(j.consulta());
        }
        
        System.out.println("\n2- Usando um Iterador ");
        for(Iterator <Caixa> itera = c.iterator(); itera.hasNext();){
            System.out.println(itera.next().consulta());
        }
        
    }
}


package gestor;


public class Gestor {


    public static void main(String[] args) {
              
        Automovel v= new Automovel("11-AA-11", "MERCEDES", "CLS", 100, 7, 6); //passado por parametros
        v.print();
        Automovel v1 = new Automovel();
        v1.setMatricula("22-AA-22");
        v1.setMarca("BMW");
        v1.setModelo("I8");
        v1.setQuilometros(100000);
        v1.setLugares(5);
        v1.setM_litros(8);
        v1.print(); // vai revelar a matricula 22-AA-22, a marca BMW, o modelo que é o I8 e os quilometros que são 100000
        
        if(v.comparaquilometros(v1) == 1){
            System.out.println("O primeiro automovel tem mais quilometros");
        }else if(v.comparaquilometros(v1) == -1){
            System.out.println("O segundo automovel tem mais quilometros");
        }else{
            System.out.println("Têm o mesmo numero de quilometros");
        }

    }
    
}
   
    


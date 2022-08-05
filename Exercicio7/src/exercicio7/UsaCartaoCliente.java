
package exercicio7;


public class UsaCartaoCliente {
    
    public static void main(String[] args) {
    CartaoCliente c1 = new CartaoCliente ();    
    c1.setCartaoCliente(123456789);
    c1.setTitularDoCartao("Hugo Queirós");
    c1.print();
    System.out.println();
   
   
    CartaoCliente c2 = new CartaoCliente (987654321,"António");
    c1.Creditarpontos(45.5 + c1.getPontosDoCartao());
    c2.Debitarpontos(c2.getPontosDoCartao()- 20.0);
    c2.setTransferepontos(c1);
    c2.print();
}
}

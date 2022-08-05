package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) throws ParseException {

		Scanner leitura = new Scanner(System.in);
                Cliente c = new Cliente();
                Produto p = new Produto();
                Produto_pedido pp = new Produto_pedido();
		
		System.out.print("Nome da Encomenda: ");
		String nome = leitura.nextLine();
                c.setName(nome);
		
		Pedido order = new Pedido(c);
		
		System.out.print("Quantidade de produtos distintos: ");
		int n = leitura.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Informações do " + i + "º produto:");
			System.out.print("\nNome: ");
			leitura.nextLine();
			String nome_p = leitura.nextLine();
                        p.setName(nome_p);
			System.out.print("Quantidade: ");
			int qnt = leitura.nextInt();
                        pp.setQuantity(qnt);
			System.out.print("Preço da unidade: ");
                        double preco_p = leitura.nextDouble();
			
                        Produto j = new Produto(nome_p, preco_p);
			
			Produto_pedido it = new Produto_pedido(qnt, preco_p, j);
			
			order.addItem(it);			
		}
		
		System.out.println();
		System.out.println(order);
		
		leitura.close();
	}
}

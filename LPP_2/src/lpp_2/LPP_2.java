package lpp_2;

import java.util.Scanner;

public class LPP_2 {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        Empresa erp = new Empresa();
        Restaurante res = new Restaurante();
        erp.nome = "ERP";
        erp.setFundador("ISPGaya");
        erp.ano_fund = 2021;
        res.setSetor("Restauração");
        
        Cliente c = new Cliente();
        Produto p = new Produto();
        Produto_pedido pp = new Produto_pedido();

        System.out.print("Nome da Encomenda: ");
        String nome = leitura.nextLine();
        c.setNome(nome);
        System.out.print("Nº Telemóvel: ");
        int nmrt = leitura.nextInt();
        if(nmrt>=910000000 && nmrt<=969999999){
        c.setNmrt(nmrt);
        }
        erp.cliente = c;
        erp.print();

        Encomenda order = new Encomenda(c);

        System.out.print("Quantidade de produtos distintos: ");
        int n = leitura.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Informações do " + i + "º produto:");
            System.out.print("\nNome: ");
            leitura.nextLine();
            String nome_p = leitura.nextLine();
            p.setNome(nome_p);
            System.out.print("Quantidade: ");
            int qnt = leitura.nextInt();
            pp.setQuantidade(qnt);
            System.out.print("Preço da unidade: ");
            double preco_p = leitura.nextDouble();

            Produto j = new Produto(nome_p, preco_p);

            Produto_pedido it = new Produto_pedido(qnt, preco_p, j);
            
            //ideia e perguntar se quer adicionar ou remover mais algo

            order.adicionar_pro(it);
        }

        System.out.println();
        System.out.println(order);
    }
}

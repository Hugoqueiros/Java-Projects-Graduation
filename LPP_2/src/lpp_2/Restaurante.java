package lpp_2;

public class Restaurante extends Empresa {
    
    private String setor;
    
    
    public Restaurante() {
        super();
        setor = "";
    }

    public Restaurante(String nome, String fundador, int ano_fund, String setor) {
        super(nome, fundador, ano_fund);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void print() {
        super.print();
        System.out.println("Setor: " + setor);
    }

}

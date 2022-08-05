package lpp_2;

public class Empresa {
    
    protected String nome;
    private String fundador;
    public int ano_fund;
    Cliente cliente;
    
    // construtor sem parametros
    public Empresa(){
        nome = "";
        fundador = "";
        ano_fund= 1;
    }
    
    // construtor com parametros
    public Empresa( String nome, String fundador, int ano_fund){
        this.nome = nome;
        this.fundador = fundador;
        this.ano_fund = ano_fund;
    }
    
    public Empresa( String nome, String fundador, int ano_fund, Cliente cliente){
        this.nome = nome;
        this.fundador = fundador;
        this.ano_fund = ano_fund;
        this.cliente = cliente;
    }
    
    // metodos de instancia - metodos de acesso
    // os metodos de instancia apenas atuam sobre as variaveis de instancia
    public void setNome( String nome ){  // metodo modificador
        this.nome = nome;
    }
    
    public String getNome(){  // metodo interrogador
        return nome;
    }

    public int getAno_fund() {
        return ano_fund;
    }

    public void setAno_fund(int ano_fund) {
        this.ano_fund = ano_fund;
    }   

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public void print(){
        System.out.println("\n__________Informações da Empresa_________");
        System.out.println( "Nome da Empresa: " + nome );
        System.out.println("Nome do Fundador da Empresa: " + fundador);
        System.out.println( "Ano de Fundação: " + ano_fund ); 
        System.out.println("\nSuas Informações\n" + cliente);
    }
    
    @Override // sobreposiÃ§Ã£o (override) do mÃ©todo toString
    public String toString(){
        return "" + nome + "|" + fundador + "|" + ano_fund;
    }
}
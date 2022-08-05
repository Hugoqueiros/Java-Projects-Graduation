package lpp_2;

public class Cliente {

    private String nome;
    private int nmrt;

    public Cliente() {
        nome = "";
        nmrt = 1;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNmrt() {
        return nmrt;
    }

    public void setNmrt(int nmrt) {
        this.nmrt = nmrt;
    }

    @Override
    public String toString() {
        return "Nome do Cliente: " + nome + "\nNº Telemóvel=" + nmrt;
    }
    
    public void print() {
        System.out.println("Informações do Cliente");
        System.out.println("\nNome: " + nome);
        System.out.println("Nº Telemóvel: " + nmrt);
    }
}

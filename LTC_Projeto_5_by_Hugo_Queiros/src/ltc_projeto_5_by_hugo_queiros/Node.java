package ltc_projeto_5_by_hugo_queiros;

public class Node implements Comparable<Node> {

    private int dados;
    private Node esquerda;
    private Node direita;

    Node() {
    }

    public int getDados() {
        return dados;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDados(int d) {
        dados = d;
    }

    public void setEsquerda(Node e) {
        esquerda = e;
    }

    public void setDireita(Node d) {
        direita = d;
    }

    public String toString() {
        return "Valor do no: " + dados;
    }

    // necessario para poder usar Collections.sort()
    public int compareTo(Node n) {
        if (dados > n.dados) {
            return 1;
        } else {
            if (dados < n.dados) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

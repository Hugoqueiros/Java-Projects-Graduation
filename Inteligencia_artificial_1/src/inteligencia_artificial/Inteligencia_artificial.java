package inteligencia_artificial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inteligencia_artificial {

    public static class Celula {

        public int x;
        public int y;
        public Celula previous;

        public Celula(int x, int y, Celula previous) {
            this.x = x;
            this.y = y;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        @Override
        public boolean equals(Object o) {
            Celula ponto = (Celula) o;
            return x == ponto.x && y == ponto.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Celula divisao(int ox, int oy) {
            return new Celula(x + ox, y + oy, this);
        }
    }

    public static boolean Possivel(String[][] fabrica, Celula ponto) {
        if (ponto.y < 0 || ponto.y > fabrica.length - 1 ) {
            return false;
        }
        if (ponto.x < 0 || ponto.x > fabrica[0].length - 1) {
            return false;
        }
        if(fabrica[ponto.x][ponto.y] == "O"){
            return false;
        }
        return true;
    }

    public static List<Celula> Vizinhanca(String[][] fabrica, Celula ponto) {
        List<Celula> neighbors = new ArrayList<>();
        Celula acima = ponto.divisao(0, 1);
        Celula baixo = ponto.divisao(0, -1);
        Celula esquerda = ponto.divisao(-1, 0);
        Celula direita = ponto.divisao(1, 0);
        if (Possivel(fabrica, acima)) {
            neighbors.add(acima);
        }
        if (Possivel(fabrica, baixo)) {
            neighbors.add(baixo);
        }
        if (Possivel(fabrica, esquerda)) {
            neighbors.add(esquerda);
        }
        if (Possivel(fabrica, direita)) {
            neighbors.add(direita);
        }
        return neighbors;
    }

    public static List<Celula> DescobreCaminho(String[][] fabrica, Celula inicio, Celula fim) {
        boolean acabado = false;
        List<Celula> array_inicial = new ArrayList<>();
        array_inicial.add(inicio);
        while (!acabado) {
            List<Celula> array_novo = new ArrayList<>();
            for (int i = 0; i < array_inicial.size(); ++i) {
                Celula ponto = array_inicial.get(i);
                for (Celula neighbor : Vizinhanca(fabrica, ponto)) {
                    if (!array_inicial.contains(neighbor) && !array_novo.contains(neighbor)) {
                        array_novo.add(neighbor);
                    }
                }
            }

            for (Celula ponto : array_novo) {
                array_inicial.add(ponto);
                if (fim.equals(ponto)) {
                    acabado = true;
                    break;
                }
            }

            if (!acabado && array_novo.isEmpty()) {
                return null;
            }
        }

        List<Celula> caminho = new ArrayList<>();
        Celula ponto = array_inicial.get(array_inicial.size() - 1);
        while (ponto.previous != null) {
            caminho.add(0, ponto);
            ponto = ponto.previous;
        }
        return caminho;
    }

    public static void main(String[] args) {
        int encontra_x= 0;
        int encontra_y = 0;
        int contador = 0;
        String[][] fabrica = {
            {"R", "L", "L", "L", "L"},
            {"O", "B", "L", "O", "L"},
            {"O", "O", "O", "O", "L"},
            {"L", "L", "L", "O", "L"},
            {"L", "L", "L", "O", "L"}
        };

        for (int i = 0; i < fabrica.length; i++) {
            for (int j = 0; j < fabrica.length; j++) {
                if (fabrica[i][j] == "B") {
                    encontra_x = i;
                    encontra_y = j;
                }
            }
        }
        
        Celula inicio = new Celula (0,0,null);
        Celula fim = new Celula(encontra_x, encontra_y, null);
        Celula newinicio = fim;
        Celula newfim = new Celula(4, 4, null);
        List<Celula> caminho = DescobreCaminho(fabrica, inicio, fim);
        if (caminho != null) {
            for (Celula ponto : caminho) {
                System.out.println(ponto);
                contador = contador + 1;
            }
        } else {
            System.out.println("Não é possível traçar caminho");
        }
        List<Celula> caminho1 = DescobreCaminho(fabrica, newinicio, newfim);
        if (caminho1 != null) {
            for (Celula ponto : caminho1) {
                System.out.println(ponto);
                contador = contador + 1;
            }
        } else {
            System.out.println("Não é possível traçar caminho");
        }
        System.out.println("Custo Total: " + contador);

    }
}

package robot_agent;

import java.util.Objects;

public class Celula {

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

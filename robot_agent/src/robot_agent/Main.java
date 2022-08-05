package robot_agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean Possivel(String[][] fabrica, Celula ponto, int bn, int n_box, int capacidade) {
        if (ponto.y < 0 || ponto.y > fabrica.length - 1) {
            return false;
        }
        if (ponto.x < 0 || ponto.x > fabrica[0].length - 1) {
            return false;
        }
        if (fabrica[ponto.x][ponto.y] == "O |") {
            return false;
        }
        if (capacidade == 1 && fabrica[ponto.x][ponto.y] == "B |") {
            return false;
        }
        return true;
    }

    public static List<Celula> Vizinhanca(String[][] fabrica, Celula ponto, int bn, int n_box, int capacidade) {
        List<Celula> neighbors = new ArrayList<>();
        Celula acima = ponto.divisao(0, 1);
        Celula baixo = ponto.divisao(0, -1);
        Celula esquerda = ponto.divisao(-1, 0);
        Celula direita = ponto.divisao(1, 0);
        if (Possivel(fabrica, acima, bn, n_box, capacidade)) {
            neighbors.add(acima);
        }
        if (Possivel(fabrica, baixo, bn, n_box, capacidade)) {
            neighbors.add(baixo);
        }
        if (Possivel(fabrica, esquerda, bn, n_box, capacidade)) {
            neighbors.add(esquerda);
        }
        if (Possivel(fabrica, direita, bn, n_box, capacidade)) {
            neighbors.add(direita);
        }
        return neighbors;
    }

    public static List<Celula> DescobreCaminho(String[][] fabrica, Celula inicio, Celula fim, int bn, int n_box, int capacidade) {
        boolean acabado = false;
        List<Celula> array_inicial = new ArrayList<>();
        array_inicial.add(inicio);
        while (!acabado) {
            List<Celula> array_novo = new ArrayList<>();
            for (int i = 0; i < array_inicial.size(); ++i) {
                Celula ponto = array_inicial.get(i);
                for (Celula neighbor : Vizinhanca(fabrica, ponto, bn, n_box, capacidade)) {
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
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual o tamanho da fábrica?");
        int tf = leitura.nextInt();
        Factory f = new Factory(0, 0, tf, tf);
        String[][] grid = f.createGrid();
        int randx = 0, randy = 0, custo_estimativo = 0, custo = 0, n_box = 0;
        boolean no_path = false;

        System.out.println("Quantas caixas pretende inserir?");
        int bn = leitura.nextInt();

        //LOCALIZAÇÃO OBSTÁCULOS
        for (int i = 0; i < tf * 1.5; i++) {
            randy = (int) (Math.random() * f.getMax_y()) + 0;
            while (randy == 0 || randy == f.getMax_y() - 1) {
                randy = (int) (Math.random() * f.getMax_y()) + 0;
            }
            randx = (int) (Math.random() * f.getMax_x()) + 0;
            grid[randy][randx] = "O |";
        }

        //LOCALIZAÇÃO CAIXAS
        for (int i = 0; i < bn; i++) {
            randy = (int) (Math.random() * f.getMax_y()) + 0;
            randx = (int) (Math.random() * f.getMax_x()) + 0;
            while (randy == 0 || randy == f.getMax_y() - 1 || grid[randy][randx] == "O |") {
                randy = (int) (Math.random() * f.getMax_y()) + 0;
                randx = (int) (Math.random() * f.getMax_x()) + 0;
            }
            grid[randy][randx] = "B |";
        }
        System.out.println();

        //LOCALIZAÇÃO ARMAZÉM
        grid[f.getMax_y() - 1][f.getMax_x() - 1] = "A |";

        //LOCALIZAÇÃO DO ROBO
        grid[f.getRobot_position_y()][f.getRobot_position_x()] = "R |";
        
        //PRINT DA MATRIZ
        for (int i = 0; i < f.getMax_y(); i++) {
            for (int j = 0; j < f.getMax_x(); j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        f.setRobot_position_y(0);
        f.setRobot_position_x(0);
        Celula position_robo = new Celula(f.getRobot_position_x(), f.getRobot_position_y(), null);

        while (n_box < bn) {
            if (f.getRobot_position_x() == 0 && f.getRobot_position_y() == 0) {
                for (int i = 0; i < grid.length; i++) {
                    if (n_box == 0) {
                        for (int j = 0; j < grid.length; j++) {
                            int capacidade = 0;
                            if (grid[i][j] == "B |") {
                                n_box++;
                                if (!no_path) {
                                    Celula box_position = new Celula(i, j, null);
                                    //DESCOBRE CAMINHO DO ROBO À BOX
                                    List<Celula> caminho = DescobreCaminho(grid, position_robo, box_position, bn, n_box, capacidade);
                                    if (caminho != null) {
                                        for (Celula ponto : caminho) {
                                            System.out.print(ponto + " -> ");
                                            custo++;
                                        }
                                        custo_estimativo = j - f.getRobot_position_x() + i - f.getRobot_position_y();
                                        capacidade = 1;
                                        
                                    } else {
                                        System.out.println("Não é possível traçar caminho até à caixa " + n_box);
                                        if (n_box == 1) {
                                            no_path = true;
                                        }
                                    }
                                    grid[i][j] = "L |";
                                    if (!no_path) {
                                        Celula position_storage = new Celula(f.getMax_y() - 1, f.getMax_x() - 1, null);
                                        //DESCOBRE CAMINHO DA BOX AO ARMAZEM
                                        List<Celula> caminho1 = DescobreCaminho(grid, box_position, position_storage, bn, n_box, capacidade);
                                        if (caminho1 != null) {
                                            for (Celula ponto : caminho1) {
                                                System.out.print(ponto + " -> ");
                                                custo = custo + 1;
                                            }
                                            f.setRobot_position_y(f.getMax_y() - 1);
                                            f.setRobot_position_x(f.getMax_x() - 1);
                                            custo_estimativo = custo_estimativo + f.getMax_x() - j + f.getMax_y() - i - 2;
                                            break;
                                        } else {
                                            no_path = true;
                                            System.out.println("Não é possível traçar caminho até ao armazem");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = f.getRobot_position_y(); i >= 0; i--) {
                    for (int j = f.getRobot_position_x(); j >= 0; j--) {
                        int capacidade = 0;
                        if (grid[i][j] == "B |") {
                            n_box++;
                            if (!no_path) {
                                if (n_box > 1) {
                                    f.setRobot_position_y(f.getMax_y() - 1);
                                    f.setRobot_position_x(f.getMax_x() - 1);
                                    position_robo = new Celula(f.getRobot_position_x(), f.getRobot_position_y(), null);
                                }
                                Celula box_position = new Celula(i, j, null);
                                //DESCOBRE CAMINHO DO ROBO À BOX
                                List<Celula> caminho = DescobreCaminho(grid, position_robo, box_position, bn, n_box, capacidade);
                                if (caminho != null) {
                                    for (Celula ponto : caminho) {
                                        System.out.print(ponto + " -> ");
                                        custo++;
                                    }
                                    capacidade = 1;
                                    custo_estimativo = custo_estimativo + (f.getMax_x() - j + f.getMax_y() - i - 2) * 2;
                                } else {
                                    System.out.println("Não é possível traçar caminho até à caixa " + n_box);
                                    if (n_box == 1) {
                                        no_path = true;
                                    }
                                }
                                grid[i][j] = "L |";
                                if (!no_path) {
                                    Celula position_storage = new Celula(f.getMax_y() - 1, f.getMax_x() - 1, null);
                                    //DESCOBRE CAMINHO DA BOX AO ARMAZEM
                                    List<Celula> caminho1 = DescobreCaminho(grid, box_position, position_storage, bn, n_box, capacidade);
                                    if (caminho1 != null) {
                                        for (Celula ponto : caminho1) {
                                            System.out.print(ponto + " -> ");
                                            custo = custo + 1;
                                        }
                                    } else {
                                        no_path = true;
                                        System.out.println("Não é possível traçar caminho até ao armazem");
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        System.out.println("\nCusto estimativo: " + custo_estimativo);
        System.out.println("\nCusto Total: " + custo);
    }
}

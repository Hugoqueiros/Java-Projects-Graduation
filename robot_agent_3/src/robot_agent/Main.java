package robot_agent;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual o tamanho da fábrica?");
        int tf = leitura.nextInt();
        Factory f = new Factory(0, 0, tf, tf);
        String[][] grid = f.createGrid();
        int randx = 0, randy = 0, custo_estimativo = 0, k = 0, custo_estimativo_total = 0;

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

        grid[0][0] = "R |";
        grid[0][1] = "L |";
        grid[0][2] = "L |";
        grid[0][3] = "L |";
        grid[0][4] = "L |";
        grid[1][0] = "L |";
        grid[1][1] = "L |";
        grid[1][2] = "O |";
        grid[1][3] = "L |";
        grid[1][4] = "L |";
        grid[2][0] = "O |";
        grid[2][1] = "L |";
        grid[2][2] = "O |";
        grid[2][3] = "O |";
        grid[2][4] = "L |";
        grid[3][0] = "L |";
        grid[3][1] = "O |";
        grid[3][2] = "B |";
        grid[3][3] = "L |";
        grid[3][4] = "L |";
        grid[4][0] = "L |";
        grid[4][1] = "L |";
        grid[4][2] = "L |";
        grid[4][3] = "L |";
        grid[4][4] = "A |";

        //PRINT DA MATRIZ
        for (int i = 0; i < f.getMax_y(); i++) {
            for (int j = 0; j < f.getMax_x(); j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        //CALCULAR CUSTO ESTIMATIVO
        for (int i = 0; i < f.getMax_y(); i++) {
            for (int j = 0; j < f.getMax_x(); j++) {
                if (grid[i][j] == "B |") {
                    k += 1;
                    if (f.getRobot_position_y() == f.getMax_y() - 1 && f.getRobot_position_x() == f.getMax_x() - 1) {
                        custo_estimativo = ((i - f.getRobot_position_y()) + (j - f.getRobot_position_x())) * -2;
                    } else {
                        //CORRIGIR VALOR SE O TAMANHO DA FABRICA FOR DIFERENTE
                        custo_estimativo = 18;
                    }
                    custo_estimativo_total += custo_estimativo;
                    f.setRobot_position_y(f.getMax_y() - 1);
                    f.setRobot_position_x(f.getMax_x() - 1);
                }
            }
        }

        System.out.println("\nCusto Estimativo Total: " + custo_estimativo_total);

        Node head = new Node(1, grid[0][0]);
        Node head_auxi = new Node(1, grid[0][0]);
        Node head_auxj = new Node(1, grid[0][0]);
        head.g = 0;
        Node n1 = new Node();
        Node n2 = new Node();
        int i = 0, j = 0;
        while (i < 3 && j < 3) {
            if (i == j) {
                n1 = new Node(1, grid[i + 1][j]);
                n2 = new Node(1, grid[i][j + 1]);
                head.addBranch(1, n1);
                head.addBranch(1, n2);
                i++;
            } else if (i > j) {
                if (j != 0) {
                    head = head_auxi;
                    Node teste2 = new Node(1, grid[i + 1][0]);
                    head.addBranch(1, teste2);
                } else {
                    head = n1;
                }

                if (j - 1 > 0) {
                    Node teste = new Node(1, grid[i + 1][j - 1]);
                    head.addBranch(1, teste);
                }

                Node n3 = new Node(1, grid[i + 1][j]);
                head_auxi = n3;
                Node n4 = new Node(1, grid[i][j + 1]);
                head.addBranch(1, n3);
                head.addBranch(1, n4);

                j++;
                i--;
            } else if (j > i) {
                if (i != 0) {
                    head = head_auxj;
                    Node teste2 = new Node(1, grid[0][j + 1]);
                } else {
                    head = n2;
                }
                if (i - 1 > 0) {
                    Node teste = new Node(1, grid[i - 1][j + 1]);
                    head.addBranch(1, teste);
                }
                Node n4 = new Node(1, grid[i + 1][j]);
                Node n5 = new Node(1, grid[i][j + 1]);
                head_auxj = n5;
                head.addBranch(1, n5);
                head.addBranch(1, n4);
                i++;
                head = n4;
            }

        }

        int nivel = 1, x = 0, y = 0;
        while(true){
            if(nivel == 1){
                Node head = new Node(1, grid[0][0]);
                n1 = new Node(1, grid[x +1]][y]);
                n2 = new Node(1, grid[x][y + 1]);
                head.addBranch(1, n1);
                head.addBranch(1, n2);
                n = n + 1;
                x = x + 1;
                y = y + 1;
            }
            if(nivel == 2){
                head= n1;
                n3 = new Node(1, grid[x +1]][0]);
                n4 = new Node(1, grid[x][y]);
                head.addBranch(1, n3);
                head.addBranch(1, n4);
                head= n2;
                n5 = new Node(1, grid[x][y+1]);
                head.addBranch(1, n5);
                head.addBranch(1, n4);
                n = n + 1,
                x= x + 1;
                y = y + 1;
            }
            if(nivel == 3){
                head = n3;
                n6 = new Node(1, grid[x +1]][0]);
                n7 = new Node(1,  grid[x][y-1]);
                n4 = new Node(1, grid[x][y]);
            }
        }

    }

}

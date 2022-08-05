package robot_agent;

public class Factory {

    private int robot_position_x = 0, robot_position_y = 0, max_x, max_y;

    public Factory() {
    }

    public Factory(int robot_position_x, int robot_position_y, int max_x, int max_y) {
        this.robot_position_x = robot_position_x;
        this.robot_position_y = robot_position_y;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    public int getRobot_position_x() {
        return robot_position_x;
    }

    public void setRobot_position_x(int robot_position_x) {
        this.robot_position_x = robot_position_x;
    }

    public int getRobot_position_y() {
        return robot_position_y;
    }

    public void setRobot_position_y(int robot_position_y) {
        this.robot_position_y = robot_position_y;
    }

    public int getMax_x() {
        return max_x;
    }

    public void setMax_x(int max_x) {
        this.max_x = max_x;
    }

    public int getMax_y() {
        return max_y;
    }

    public void setMax_y(int max_y) {
        this.max_y = max_y;
    }

    public String[][] createGrid() {

        String[][] a = new String[this.max_y][this.max_x];

        for (int i = 0; i < this.max_y; i++) {
            for (int j = 0; j < this.max_x; j++) {
                a[i][j] = "L |";
            }
        }
        a[this.robot_position_y][this.robot_position_y] = "R";

        return a;
    }

}

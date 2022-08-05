package robot_agent;

public class Obstacle {

    private int position_x, position_y;

    public Obstacle() {
        position_x = 0;
        position_y = 0;
    }

    public Obstacle(int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

}

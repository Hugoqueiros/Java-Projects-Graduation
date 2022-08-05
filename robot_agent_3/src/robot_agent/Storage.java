package robot_agent;

public class Storage {

    private int position_x, position_y, capacity = 10, dimension = 0;

    public Storage() {
        position_x = 0;
        position_y = 0;
    }

    public Storage(int position_x, int position_y) {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}

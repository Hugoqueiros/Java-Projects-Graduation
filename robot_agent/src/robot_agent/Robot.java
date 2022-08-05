package robot_agent;

public class Robot {

    private int capacity = 0;
    private int dimension = 1;
    private String state = "Parado";

    public Robot() {
    }

    public Robot(int capacity, int dimension, String state) {
        this.capacity = capacity;
        this.dimension = dimension;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

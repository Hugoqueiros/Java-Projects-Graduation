
package testinterfaces;

public class TestInterfaces implements MyInterface {

    public static void main(String[] args) {
        
    }

    @Override
    public void display() {
        System.out.println(PI);;
    }
    
}

interface MyInterface{
    float PI=3.14F;
    public void display();
    
}

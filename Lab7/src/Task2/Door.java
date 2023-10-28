package Task2;

import java.util.Observable;
import java.util.Observer;

public class Door implements Observer {
    private final String name;
    public Door(String doorName){
        this.name = doorName;
    }
    public void open(){
        System.out.println("Door " + name + " opened");
    }
    public void close(){
        System.out.println("Door " + name + " closed");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg == "open"){
            open();
        }
        else if (arg == "close"){
            close();
        }
    }
}

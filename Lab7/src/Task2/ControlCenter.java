package Task2;

import java.util.*;

public class ControlCenter extends Observable{

//    private List<Door> doors = new ArrayList<>();

//    @Override
//    public void notifyObservers(Objects arg){
//        for (int i = arrLocal.length-1; i>=0; i--)
//            ((Observer)arrLocal[i]).update(this, arg);
//    }

    public void openAllDoors(){
//        for(Door d : doors){
//            d.open();
//        }
        setChanged();
        notifyObservers("open");
    }
    public void closeAllDoors(){
//        for(Door d : doors){
//            d.close();
//        }
        setChanged();
        notifyObservers("close");
    }
    public void registerObserver(Door d){
//        doors.add(d);
        this.addObserver(d);
    }

}

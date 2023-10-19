import java.util.ArrayList;

public class SingletonDemo {


    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.addUpdate("System Started");
        instance.addUpdate("First Sentece added");
        instance.showMessage();
    }
}
class Singleton{
    private  static  Singleton instance;

    private static ArrayList<String> recs = new ArrayList<String>();
    private Singleton(){
    }
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage(){
        for(String s: recs) {
            System.out.println(s);
        }
    }
    public void addUpdate(String s){
        recs.add(s);
    }
}
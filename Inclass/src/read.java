import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class read {
    public static void main(String[] args) throws  Exception{
        Scanner in = new Scanner(new FileReader("C:/Users/weera/IdeaProjects/Adv comprog/Inclass/src/file.txt"));
        while(in.hasNext()){
//            int id = in.nextInt();
            String name = in.next();
            System.out.println(": "+name);
        }
        in.close();
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class write {
    public static void main(String[] args) throws  Exception{

        String filePath = "C:/Users/weera/IdeaProjects/Adv comprog/Inclass/src/output.txt"; // Replace with the path to your output file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, World!\n");
            writer.write("This is a Java file writing example.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

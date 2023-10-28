package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileReaderSingleton {
    private static FileReaderSingleton instance;
    private BufferedReader reader;

    private FileReaderSingleton(){
        openFile();
    }
    private void openFile(){
        try{
            reader = new BufferedReader(new FileReader("data.txt"));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
    public String readLineFromFile() {
        String line = null;
        try {
            line = reader.readLine();
        }
        catch (IOException e){
            openFile();
            try {
                return reader.readLine();
            }catch (IOException e0 ){System.out.println(e0);}
        }
        return line;
    }
    public void closeFile(){
        try {
            reader.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static FileReaderSingleton getInstance(){
        if(instance == null) {
            instance = new FileReaderSingleton();
        }
        return instance;
    }
}

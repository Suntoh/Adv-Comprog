package Task1;

import java.io.*;
import java.util.*;
import java.io.FileReader;


public class TestFile {
    String fileLine;
    static HashSet<String> dataEdit = new HashSet<>();
    static int[] scores = new int[5];
    static int[] tuple = new int[2];

    public HashMap<String, int[]> read_scores(String fileName) {
        HashMap<String, int[]> data = new HashMap<>();
        try {
            Scanner in = new Scanner(new FileReader(fileName));
            String header = in.nextLine();
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] lines = line.split(",");
                int[] linesInt = new int[5];
                for (int i = 1; i < lines.length; i++) {
                    linesInt[i - 1] = Integer.parseInt(lines[i]);
                    scores[i - 1] = (linesInt[i - 1]);
                }
                data.put(lines[0], scores);
                scores = new int[5];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getTotalScore(HashMap<String, int[]> data, String id) {
        if (data.containsKey(id)) {
            int[] scores = data.get(id);
            int sum = 0;
            for (int i : scores) {
                sum += i;
            }
            return sum;
        } else {
            System.out.println(id + " not found.");
        }
        return 0;
    }

    public HashSet<String> getEditedStudentID(String fileName) {
        try {
            Scanner in = new Scanner(new FileReader(fileName));
            String header = in.nextLine();
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] lines = line.split(",");
                dataEdit.add(lines[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataEdit;
    }

    public HashMap<String, ArrayList<int[]>> readEdit(String edit) {
        ArrayList<int[]> editedScores = new ArrayList<>();
        HashMap<String, ArrayList<int[]>> data = new HashMap<>();
        try {
            Scanner in = new Scanner(new FileReader(edit));
            String header = in.nextLine();
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] lines = line.split(",");
                int[] linesInt = new int[3];
                for (int i = 1; i < lines.length; i++) {
                    linesInt[i - 1] = Integer.parseInt(lines[i]);
                    tuple[i - 1] = (linesInt[i - 1]);
                }
                editedScores.add(tuple);

                if (!data.containsKey(lines[0])) {
                    data.put(lines[0], editedScores);
                } else {
                    data.get(lines[0]).add(tuple);
                }
                tuple = new int[2];
                editedScores = new ArrayList<>();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void createNewEditedScore(String original, String edit, String newFile) {
        HashMap<String, int[]> originalFile = read_scores(original);
        HashMap<String, ArrayList<int[]>> editFile = readEdit(edit);
        HashSet<String> ids = getEditedStudentID(edit);
//        for (String studentID : editFile.keySet()) {
//            System.out.println(studentID + " - " + Arrays.toString(editFile.get(studentID)));
//        }
        for (String id : ids) {
            int [] scoresWant = originalFile.get(id);
//            System.out.println(Arrays.toString(scoresWant));
            ArrayList<int[]> editedScore = editFile.get(id);
            for (int[] q : editedScore) {
//                System.out.println(Arrays.toString(q));
                scoresWant[q[0] - 1] = q[1];
            }
//            System.out.println(id + " - " + Arrays.toString(originalFile.get(id)));
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            String temp = null;
            String[] temp2  = new String[5];
            writer.write("ID,Quiz1,Quiz2,Quiz3,Quiz4,Quiz5");
            for (String studentID : originalFile.keySet()) {
                for(int i = 0;i<5;i++){
                    temp2[i]= Integer.toString(originalFile.get(studentID)[i]);
                }
//                System.out.println(Arrays.toString(temp2));
                temp = String.join(",",temp2);
                writer.write(studentID + "," + temp + '\n');
//                System.out.println(studentID + " - " + Arrays.toString(originalFile.get(studentID)));
//                System.out.println(studentID + ',' + temp);
                temp = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

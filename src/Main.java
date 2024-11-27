import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int count = 0;
        int valid = 0;
        ArrayList<String> fileData = getFileData("src/input");
        //String[] splitSample = sample.split(" ");
        System.out.println(fileData);
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] hi = fileData.get(i).split(" ");
            String[] bye = hi[0].split("-");
            int low = Integer.parseInt(bye[0]);
            int high = Integer.parseInt(bye[1]);
            String target = hi[1].substring(0,1);
            for(int j = 0; j < hi[2].length(); j ++){
                if(hi[2].substring(j, j + 1).equals(target)){
                    count ++;
                }
            }
            if(count <= high && count >= low){
                valid ++;
            }
            count = 0;
        }
        System.out.println(valid);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

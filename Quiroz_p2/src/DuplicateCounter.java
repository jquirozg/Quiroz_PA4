import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {

    HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException {
        FileInputStream fileToOpen = null;
        Scanner inFS = null;

        fileToOpen = new FileInputStream(dataFile);
        inFS = new Scanner(fileToOpen);

        String word;
        int i = 0;

        while(inFS.hasNext()) {
            word = inFS.next();
            i = 1;
            if(wordCounter.containsKey(word)) {
                i = wordCounter.get(word);
                i++;
            }
            wordCounter.put(word, i);
        }
        fileToOpen.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream outFile = null;
        PrintWriter outFS = null;
        outFile= new FileOutputStream(outputFile);
        outFS = new PrintWriter(outFile);

        outFS.println(wordCounter.toString());
        outFS.flush();

        outFile.close();
    }
}

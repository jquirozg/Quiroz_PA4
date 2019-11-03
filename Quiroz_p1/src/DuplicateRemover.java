import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class DuplicateRemover {

    HashSet<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) throws IOException {
        FileInputStream fileToOpen = null;
        Scanner inFS = null;

        fileToOpen = new FileInputStream(dataFile);
        inFS = new Scanner(fileToOpen);

        LinkedList<String> list = new LinkedList<String>();

        String word;

        while(inFS.hasNext()) {
            word = inFS.next();
            list.add(word);
        }

        int size = list.size();

        int i;

        for (i = 0; i < size; i++){
            if(!(uniqueWords.contains(list.get(0)))){
                uniqueWords.add(list.get(0));
            }
            list.remove(0);
        }

        fileToOpen.close();

    }

    public void write(String outputFile) throws IOException {

        FileOutputStream outFile = null;
        PrintWriter outFS = null;
        outFile= new FileOutputStream(outputFile);
        outFS = new PrintWriter(outFile);

        outFS.println(uniqueWords.toString());
        outFS.flush();

        outFile.close();
    }
}

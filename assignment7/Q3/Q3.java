package assignment7.Q3;

import java.io.*;

public class Q3 {
    public static void countLines(String[] files) {
        for (String file : files) {
            try {
                int count = 0;
                File inputFile = new File(file);
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                while (reader.readLine() != null) count++;
                System.out.println(file + " has number of lines: " + count);
            } catch (IOException e) {
                System.out.println("Error while reading " + file);
            }
        }
    }

    public static void main(String[] files) {
        Q3.countLines(files);
    }
}
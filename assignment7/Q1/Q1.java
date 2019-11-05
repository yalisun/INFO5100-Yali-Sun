package assignment7.Q1;

import java.io.*;

public class Q1 {

    public static void reverse(String input, String output) throws Exception {
        File inputFile = new File(input);
        File outputFile = new File(output);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String str = reader.readLine();
            writer.write(reverse(str));
        }
    }

    private static String reverse(String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

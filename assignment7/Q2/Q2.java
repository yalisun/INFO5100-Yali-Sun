package assignment7.Q2;

import java.io.*;
import java.util.Stack;

public class Q2 {

    public static void decode(String inputFile, String outputFile) throws IOException {
        File input =  new File(inputFile);
        File output = new File(outputFile);
        BufferedReader reader = new BufferedReader(new FileReader(input));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            String currLine = reader.readLine();
            writer.write(decode(currLine));
        }
    }

    private static String decode(String input) {
        int idx = 0;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        while (idx < input.length()) {
            if (Character.isDigit(input.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(input.charAt(idx))) {
                    count = 10 * count + (input.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (input.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (input.charAt(idx) == ']') {
                int repeat = countStack.pop();
                StringBuilder sb = new StringBuilder(resStack.pop());
                for (int i = 0; i < repeat; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += input.charAt(idx);
                idx++;
            }
        }
        return res.trim();
    }
}

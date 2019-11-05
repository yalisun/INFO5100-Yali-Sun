package assignment7.Q1;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import java.io.*;

public class Q1Test {

    @Test
    public void test_reverse() throws Exception {
        String input = "src/assignment7/Q1/inputFile.txt";
        String output = "src/assignment7/Q1/outputFile.txt";
        Q1.reverse(input, output);
        BufferedReader file = new BufferedReader(new FileReader(output));
        assertEquals("blue is sky the", file.readLine());
    }
}

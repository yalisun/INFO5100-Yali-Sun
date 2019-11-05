package assignment7.Q2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class Q2Test {

    @Test
    public void test_decode1() throws Exception {
        String inputFile = "src/assignment7/Q2/data/inputFile1.txt";
        String outputFile = "src/assignment7/Q2/data/outputFile1.txt";
        Q2.decode(inputFile, outputFile);
        BufferedReader output = new BufferedReader(new FileReader(outputFile));
        assertEquals("aaabcbc", output.readLine());
    }

    @Test
    public void test_decode2() throws Exception {
        String inputFile = "src/assignment7/Q2/data/inputFile2.txt";
        String outputFile = "src/assignment7/Q2/data/outputFile2.txt";
        Q2.decode(inputFile, outputFile);
        BufferedReader output = new BufferedReader(new FileReader(outputFile));
        assertEquals("accaccacc", output.readLine());
    }

    @Test
    public void test_decode3() throws Exception {
        String inputFile = "src/assignment7/Q2/data/inputFile3.txt";
        String outputFile = "src/assignment7/Q2/data/outputFile3.txt";
        Q2.decode(inputFile, outputFile);
        BufferedReader output = new BufferedReader(new FileReader(outputFile));
        assertEquals("abcabccdcdcdef", output.readLine());
    }
}

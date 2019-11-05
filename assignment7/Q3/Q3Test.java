package assignment7.Q3;

import org.junit.Test;

public class Q3Test {

    @Test
    public void test_countLines() {
        String[] files = {
                "src/assignment7/Q3/data/file1.txt",
                "src/assignment7/Q3/data/file2.txt",
                "src/not/exist/file",
                "src/assignment7/Q3/data/file3.txt"
        };
        Q3.countLines(files);
        /*  Standard output:

            src/assignment7/Q3/Files/file1.txt has number of lines: 3
            src/assignment7/Q3/Files/file2.txt has number of lines: 6
            Error while reading x
            src/assignment7/Q3/Files/file3.txt has number of lines: 9
         */
    }
}

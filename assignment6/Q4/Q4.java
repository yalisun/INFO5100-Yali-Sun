package assignment6.Q4;

import java.util.HashSet;
import java.util.Set;

public class Q4 {

    //solution1
    public static boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        for (int i : arr) {
            counts[i + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : counts) {
            if (i != 0) {
                if (set.contains(i)) {
                    return false;
                } else {
                    set.add(i);
                }
            }
        }
        return true;
    }

    //solution2
    public static boolean uniqueOccurrences2(int[] arr) {
        int[] counts = new int[2001];
        for (int i : arr) {
            counts[i + 1000]++;
        }
        boolean[] check = new boolean[1001];
        for (int i : counts) {
            if (i != 0) {
                if (check[i]) {
                    return false;
                } else {
                    check[i] = true;
                }
            }
        }
        return true;
    }
}

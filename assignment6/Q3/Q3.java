package assignment6.Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {

	public static boolean isAnagram(String s, String t) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			int index = c - 'a';
			counts[index]++;
		}
		for (char c : t.toCharArray()) {
			int index = c - 'a';
			counts[index]--;
		}
		for (int i = 0; i < 26; i++) {
			if (counts[i] != 0) return false;
		}
		return true;
	}
}

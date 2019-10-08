package Q5;

public class IncreaseAndDecrease {

	public static int[] permute(String s) {
		int max = s.length();
		int min = 0;
		int [] result = new int[s.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				result[i] = min;
				min++;
			} else {
				result[i] = max;
				max--;
			}
		}
		result[s.length()] = min;
		return result;
	}

	public static void main(String[] args) {
		for (int i : IncreaseAndDecrease.permute("IDID")) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : IncreaseAndDecrease.permute("III")) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : IncreaseAndDecrease.permute("DDI")) {
			System.out.print(i);
		}
	}
}

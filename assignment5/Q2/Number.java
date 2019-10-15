package assignment5.Q2;


public class Number {
	public static int count(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			// deal with divisor zero
			System.out.print(e.getMessage());
			throw e;
		} catch (Exception e) {
			// deal with all possible exception
			throw e;
		}
	}
}

package assignment5.Q4;

public class MyIndexOutOfBoundException extends RuntimeException {

	private int lowerBound;
	private int upperBound;
	private int index;

	public MyIndexOutOfBoundException(int lowerBound,
	                                  int upperBound,
	                                  int index) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}

	public String toString() {
		return String.format(
				"Error Message: Index: %s, but Lower bound: %s, Upper bound: %s",
				index,
				lowerBound,
				upperBound);
	}

	public static void main(String[] args) {
		try {
			throw new MyIndexOutOfBoundException(0, 9, 10);
		} catch (MyIndexOutOfBoundException e) {
			System.out.println(e.toString());
		}
	}

}

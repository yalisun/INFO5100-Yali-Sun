package assignment5.Q4;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class MyIndexOutOfBoundExceptionTest {

	private static final int LOWER_BOUND = 0;
	private static final int UPPER_BOUND = 9;
	private static final int INDEX = 10;

	@Test
	public void test() {
		try {
			throw new MyIndexOutOfBoundException(LOWER_BOUND, UPPER_BOUND, INDEX);
		} catch (MyIndexOutOfBoundException e) {
			String message = e.toString();
			assertTrue(message.contains(String.valueOf(LOWER_BOUND)));
			assertTrue(message.contains(String.valueOf(UPPER_BOUND)));
			assertTrue(message.contains(String.valueOf(INDEX)));
		}
	}
}

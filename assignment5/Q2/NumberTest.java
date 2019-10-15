package assignment5.Q2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberTest {

	@Test
	public void test_count() {
		assertEquals(2, Number.count(10,5));
		assertEquals(1, Number.count(6,5));
	}

	@Test(expected = ArithmeticException.class)
	public void test_dividedByZero() {
		Number.count(5,0);
	}
}

package assignment5.Q3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FullTimeTest {

	@Test
	public void test() {
		FullTime fullTime = new FullTime("linFull", 5);
		assertEquals(40, fullTime.calculateSalary());
	}
}

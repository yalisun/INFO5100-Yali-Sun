package assignment5.Q3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ContractorTest {

	@Test
	public void test() {
		Contractor contractor = new Contractor("lin", 5, 3);
		assertEquals(15, contractor.calculateSalary());
	}
}

package assignment5.Q5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PetTest {
	private static final String TO_STRING = "Spot owned by Mary\n" +
			"Color: Black and White\n" +
			"Sex: male";

	@Test
	public void test_toString() {
		Pet pet = new Pet("Spot", "Mary","Black and White");
		pet.setSex(Pet.MALE);
		assertEquals(TO_STRING, pet.toString());
	}
}

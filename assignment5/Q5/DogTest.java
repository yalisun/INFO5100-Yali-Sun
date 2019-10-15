package assignment5.Q5;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DogTest {

	private Dog dog;
	private static final String TO_STRING = "Spot owned by Susan\n" +
			"Color: white\n" +
			"Sex: spayed\n" +
			"Size: medium";

	@Before
	public void setup() {
		dog = new Dog("Spot", "Susan","white","medium");
	}

	@Test
	public void test_toString() {
		dog.setSex(Pet.SPAYED);
		assertEquals(TO_STRING, dog.toString());
	}

	@Test
	public void test_boarding() {
		dog.setBoardStart(10,1,2019);
		dog.setBoardEnd(11,1,2019);
		assertTrue(dog.boarding(11,1,2019));
		assertTrue(dog.boarding(10,20,2019));
		assertFalse(dog.boarding(11,20,2019));
		assertFalse(dog.boarding(9,20,2019));
		assertTrue(dog.boarding(10,1,2019));
	}
}

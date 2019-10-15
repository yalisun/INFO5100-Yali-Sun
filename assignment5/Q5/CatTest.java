package assignment5.Q5;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CatTest {

	private Cat cat;
	private static final String TO_STRING = "Tom owned by Bob\n" +
			"Color: black\n" +
			"Sex: spayed\n" +
			"Hair: short";

	@Before
	public void setup() {
		cat = new Cat("Tom", "Bob", "black", "short");
	}

	@Test
	public void test_toString() {
		cat.setSex(Pet.SPAYED);
		assertEquals(TO_STRING, cat.toString());
	}
	@Test
	public void test_boarding() {
		cat.setBoardStart(10,1,2019);
		cat.setBoardEnd(11,1,2019);
		assertTrue(cat.boarding(11,1,2019));
		assertTrue(cat.boarding(10,20,2019));
		assertFalse(cat.boarding(11,20,2019));
		assertFalse(cat.boarding(9,20,2019));
		assertTrue(cat.boarding(10,1,2019));
	}
}

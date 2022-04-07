package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Utilites;

class TestUtilitesClass {

	// expected - actual == epsilon/delta
	@Test
	public void test_createConfig() {
		double p = Utilites.round(1.51);
		double p2 = Utilites.round(1.529);
		double p3 = Utilites.round(1.419);

		assertEquals(1.50, p, 0);
		assertEquals(1.55, p2, 0);
		assertEquals(1.40, p3, 0);
	}

}

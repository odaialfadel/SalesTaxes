package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import app.model.Utilites;

class TestUtilitesClass {

	// expected - actual == epsilon/delta
	@Test
	public void test_round() {
		double p = Utilites.round(1.51);
		double p2 = Utilites.round(1.529);
		double p3 = Utilites.round(1.419);

		assertEquals(1.50, p, 0);
		assertEquals(1.55, p2, 0);
		assertEquals(1.40, p3, 0);
	}

	@Test
	public void test_getfirst2DiguiAfterComma() {

		DecimalFormat decimalFormat = new DecimalFormat("#.00");

		double b = 12.49;
		double a = 14.25;
		double dub = Double.valueOf(decimalFormat.format(b + a).replace(',', '.'));

		assertEquals(26.74, dub, 0);
	}

}

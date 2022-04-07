package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Calculate;
import model.Product;

class TestCalculateClass {

	Calculate[] calcu = { new Calculate(new Product("headache pills", 9.75)),
			new Calculate(new Product("imported perfume", 47.50)), new Calculate(new Product("music CD", 14.99)) };
	@Test
	public void test_createConfig() {

		calcu[2].preform();
		calcu[0].preform();
		calcu[1].preform();
		double f = calcu[1].product.getTaxFees();
		assertEquals(1.50, calcu[2].product.getTaxFees(), 0);
		assertEquals(0.00, calcu[0].product.getTaxFees(), 0);
		assertEquals(7.15, calcu[1].product.getTaxFees(), 0);

	}

}

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import app.model.Calculate;
import app.model.Product;

class TestCalculateClass {



	@Test
	public void test_input1() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("book ", 12.49));
		products.add(new Product("music CD", 14.99));
		products.add(new Product("chocolate bar", 0.85));

		Calculate better = new Calculate();

		for (Product product : products) {
			product.setTaxFees(better.preform(product).taxes(product));
			product.setGrossPrice(better.preform(product).grossPriceCalculation(product));
		}
		assertEquals(12.49, products.get(0).getGrossPrice(), 0);
		assertEquals(16.49, products.get(1).getGrossPrice(), 0);
		assertEquals(0.85, products.get(2).getGrossPrice(), 0);
	}

	@Test
	public void test_input2() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("imported box of chocolates", 10.00));
		products.add(new Product("imported bottle of perfume", 47.50));

		Calculate better = new Calculate();

		for (Product product : products) {
			product.setTaxFees(better.preform(product).taxes(product));
			product.setGrossPrice(better.preform(product).grossPriceCalculation(product));
		}
		assertEquals(10.50, products.get(0).getGrossPrice(), 0);
		assertEquals(54.65, products.get(1).getGrossPrice(), 0);
	}

	@Test
	public void test_input3() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("imported bottle of perfume", 27.99));
		products.add(new Product("bottle of perfume", 18.99));
		products.add(new Product("packet of headache", 9.75));
		products.add(new Product("box of imported chocolates ", 11.25));

		Calculate better = new Calculate();

		for (Product product : products) {
			product.setTaxFees(better.preform(product).taxes(product));
			product.setGrossPrice(better.preform(product).grossPriceCalculation(product));
		}
		assertEquals(32.19, products.get(0).getGrossPrice(), 0);
		assertEquals(20.89, products.get(1).getGrossPrice(), 0);
		assertEquals(9.75, products.get(2).getGrossPrice(), 0);
		assertEquals(11.85, products.get(3).getGrossPrice(), 0);
	}

}

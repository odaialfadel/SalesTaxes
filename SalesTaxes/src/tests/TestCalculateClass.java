package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Calculate;
import model.Product;

class TestCalculateClass {



	@Test
	public void test_totalTaxes() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("imported pills", 10.00));
		products.add(new Product("imported perfume", 47.50));
		products.add(new Product("music CD", 14.99));
		Calculate better = new Calculate();
		double b = 0;
		for (Product product : products) {
			better.preform(product);

		}
		b = products.get(0).getGrossPrice();
		System.out.println(b);

		// double f = better.totalCostProducts(products);
		// double b = better.totalTaxesCollected(products);
		assertEquals(10.50, b, 0);
		// assertEquals(81.13, f, 0);



	}

}

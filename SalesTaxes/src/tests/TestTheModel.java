package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Product;
import model.TheModel;

class TestTheModel {

	TheModel model = new TheModel();

	@Test
	public void test_totalPrice() {
		// model.calculater.getListOfProducts().add(new Product("headache pills",
		// 9.75));
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("headache pills", 9.99));
		products.add(new Product("imported perfume", 47.50));
		products.add(new Product("music CD", 14.99));
		// model.setProductList(products);

		double total = 0;
		for (Product product : products) {
			model.getCalculater().preform(product);
			total += product.getGrossPrice();
		}
		// total = model.getCalculater().totalCostProducts(products);

		assertEquals(81.13, total, 0);
	}

}

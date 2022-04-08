package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import app.model.Product;
import app.model.TheModel;

class TestTheModel {

	TheModel model = new TheModel();

	@Test
	public void test_totalPrice() {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product("headache pills", 9.99));
		products.add(new Product("imported perfume", 47.50));
		products.add(new Product("music CD", 14.99));
		model.setProductList(products);

		double total = 0;
		for (Product product : model.getProductList()) {
			total += model.getCalculater().preform(product).grossPriceCalculation(product);
		}
		assertEquals(81.13, total, 0);
	}

	// before was 860.1999999999999 that is false! so i fixed it in product class
	//
	@Test
	public void test_grossPrice() {

		List<Product> products = new ArrayList<Product>();
		double gross = 0;
		products.add(new Product("somthing", 34.00));
		model.setProductList(products);
		products.get(0)
				.setGrossPrice(
						model.getCalculater().preform(products.get(0)).grossPriceCalculation(products.get(0)) * 23);
		gross = products.get(0).getGrossPrice();

		assertEquals(860.20, gross, 0);
	}

}

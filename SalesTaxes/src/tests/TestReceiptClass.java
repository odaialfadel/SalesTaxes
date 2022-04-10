package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import app.model.Calculate;
import app.model.Product;
import app.model.Receipt;
import app.model.TheModel;
import app.model.Utilites;

class TestReceiptClass {

	@Test
	public void test_input3() {
		TheModel model = new TheModel();
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("imported bottle of perfume", 27.99));
		products.add(new Product("bottle of perfume", 18.99));
		products.add(new Product("packet of headache", 9.75));
		products.add(new Product("box of imported chocolates ", 11.25));
		model.setProductList(products);

		Calculate calculate = new Calculate();


		double collectedTaxes = 0;
		double totalPrice = 0;

		for (Product product : products) {
			calculate.preformCategory(product).preform(product);
			product.setTaxFees(product.getTaxFees());
			product.setGrossPrice(product.getGrossPrice());
			collectedTaxes += product.getTaxFees();
			totalPrice += product.getGrossPrice();
			collectedTaxes = Utilites.round(collectedTaxes);
			totalPrice = Utilites.round2DigitAfterComma(totalPrice);
		}

		Receipt receipt = new Receipt(model.getProductList(),
				model.getCalculater().totalTaxesCollected(model.getProductList()),
				model.getCalculater().totalCostProducts(model.getProductList()));
		model.setReceipt(receipt);
		assertEquals(32.19, receipt.getProductList().get(0).getGrossPrice(), 0);
		assertEquals(20.89, receipt.getProductList().get(1).getGrossPrice(), 0);
		assertEquals(9.75, receipt.getProductList().get(2).getGrossPrice(), 0);
		assertEquals(11.85, receipt.getProductList().get(3).getGrossPrice(), 0);
		assertEquals(6.70, receipt.getSalesTaxes(), 0);
		assertEquals(74.68, receipt.getTotalPrice(), 0);
	}

}

package model;

import java.util.List;

public class Calculate {

	private Product product;
	private List<Product> products;

	public Calculate(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

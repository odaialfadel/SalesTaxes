package model;

import java.util.List;

public class TheModel {

	private Calculate calculater;
	private List<Product> productList;

	public TheModel() {
		this.calculater = new Calculate();
	}

	public Calculate getCalculater() {
		return calculater;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}




}

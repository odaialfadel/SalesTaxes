package model;

import java.util.ArrayList;
import java.util.List;

public class TheModel {

	private Calculate calculater;
	private Receipt receipt;
	private List<Product> productList = new ArrayList<Product>();



	public TheModel() {
		this.calculater = new Calculate();
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Receipt getReceipt() {
		return receipt;
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

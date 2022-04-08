package app.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Product> productList = new ArrayList<Product>();
	private double SalesTaxes;
	private double totalPrice;

	public Receipt(List<Product> productList, double salesTaxes, double totalPrice) {
		this.productList = productList;
		SalesTaxes = salesTaxes;
		this.totalPrice = totalPrice;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public double getSalesTaxes() {
		return SalesTaxes;
	}

	public void setSalesTaxes(double salesTaxes) {
		SalesTaxes = salesTaxes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String receiptToString() {
		String info = "";
		for (Product product : productList) {
			info += product.getQuantity() + " " + product.getInfo() + ": " + product.getGrossPrice() + "\n";
		}
		return info + "Sales Taxes: " + Utilites.round2DigitAfterComma(SalesTaxes) + "\nTotal: "
				+ Utilites.round2DigitAfterComma(totalPrice);
	}

}

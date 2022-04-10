package app.model;

import java.util.List;

public class Receipt {

	private List<Product> productList;
	private double SalesTaxes;
	private double totalPrice;

	public Receipt(List<Product> productList, double salesTaxes, double totalPrice) {

		this.productList = productList;
		this.SalesTaxes = Utilites.round(salesTaxes);
		this.totalPrice = Utilites.round2DigitAfterComma(totalPrice);
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
		this.SalesTaxes = Utilites.round(salesTaxes);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = Utilites.round2DigitAfterComma(totalPrice);
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

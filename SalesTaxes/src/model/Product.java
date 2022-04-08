package model;

public class Product {

	private String info;
	private double netPrice;
	private double grossPrice;
	private double taxFees;
	private double quantity;


	public Product(String info, double netPrice) {
		this.info = info;
		this.netPrice = netPrice;
	}


	public double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}

	public double getTaxFees() {
		return taxFees;
	}

	public void setTaxFees(double taxFees) {
		this.taxFees = taxFees;
	}

	public String getInfo() {
		return info;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}

package model;

public class Product {

	private String info;
	private double netPrice;
	private double grossPrice;
	private double taxFees;
	private boolean taxFree = false;

	public Product(String info, double netPrice) {
		this.info = info;
		this.netPrice = netPrice;
		this.taxFree = isTaxFree();
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

	public boolean isTaxFree() {
		return taxFree;
	}

	public void setTaxFree(boolean taxFree) {
		this.taxFree = taxFree;
	}

	public String getInfo() {
		return info;
	}

	public double getNetPrice() {
		return netPrice;
	}

}

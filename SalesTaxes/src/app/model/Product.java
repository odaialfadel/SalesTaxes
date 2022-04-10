package app.model;

public class Product {

	private String info;
	private double netPrice;
	private double grossPrice;
	private double taxFees;
	private int quantity;


	public Product(String info, double netPrice) {
		this.info = info;
		this.netPrice = netPrice;
	}

	public Product(String info, double netPrice, double grossPrice, double taxFees, int quantity) {
		if (1 <= quantity) {
			taxFees = taxFees * quantity;
			grossPrice = grossPrice * quantity;

			grossPrice = Utilites.round2DigitAfterComma(grossPrice);
		} else if (0 <= quantity) {
			netPrice = 0;
			taxFees = 0;
			grossPrice = 0;
		}
		this.info = info;
		this.netPrice = netPrice;
		this.grossPrice = Utilites.round2DigitAfterComma(grossPrice);
		this.taxFees = Utilites.round(taxFees);
		this.quantity = quantity;


	}

	public double getGrossPrice() {
		return grossPrice;
	}

	public void setGrossPrice(double grossPrice) {
		if (1 <= getQuantity()) {
			grossPrice = grossPrice * getQuantity();
			grossPrice = Utilites.round2DigitAfterComma(grossPrice);
		}
		this.grossPrice = Utilites.round2DigitAfterComma(grossPrice);
	}

	public double getTaxFees() {
		return taxFees;
	}

	public void setTaxFees(double taxFees) {
		if (1 <= getQuantity()) {
			taxFees = taxFees * getQuantity();
		}
		this.taxFees = Utilites.round(taxFees);
	}

	public String getInfo() {
		return info;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

package model.taxType.taxesCalculation;

import model.Product;
import model.Utilites;
import model.taxType.TaxFees;

public class TaxFree implements TaxFees {

	@Override
	public double taxes(Product product) {
		if (product != null) {
			return 0.00;
		}
		return 0;
	}

	@Override
	public double grossPriceCalculation(Product product) {
		double grossPrice;
		if (product != null) {
			grossPrice = product.getNetPrice();
			return Utilites.round2DigitAfterComma(grossPrice);
		}
		return 0;
	}

}
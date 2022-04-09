package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

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

		if (product != null) {
			double grossPrice;
			grossPrice = product.getNetPrice();
			return Utilites.round2DigitAfterComma(grossPrice);
		}
		return 0;
	}

}

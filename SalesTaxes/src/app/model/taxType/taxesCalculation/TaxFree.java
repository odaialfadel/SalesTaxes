package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxFree implements TaxFees {

	@Override
	public void preform(Product product) {
		if (product != null) {
			double grossPrice;
			grossPrice = product.getNetPrice();

			product.setTaxFees(0.00);
			product.setGrossPrice(Utilites.round2DigitAfterComma(grossPrice));
		}
	}

}

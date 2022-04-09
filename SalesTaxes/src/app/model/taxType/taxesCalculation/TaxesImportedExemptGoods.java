package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesImportedExemptGoods implements TaxFees {

	@Override
	public double taxes(Product product) {
		if (product != null) {
			double taxes5;
			taxes5 = (product.getNetPrice() * 5) / 100;
			return Utilites.round(taxes5);
		}
		return 0;
	}

	@Override
	public double grossPriceCalculation(Product product) {
		if (product != null) {
			double grossPrice;
			grossPrice = product.getNetPrice() + taxes(product);
			return Utilites.round2DigitAfterComma(grossPrice);
		}
		return 0;
	}

}

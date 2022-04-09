package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesNormalGoods implements TaxFees {

	@Override
	public double taxes(Product product) {

		if (product != null) {
			double taxes;
			taxes = (product.getNetPrice() * 10) / 100;
			return Utilites.round(taxes);
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

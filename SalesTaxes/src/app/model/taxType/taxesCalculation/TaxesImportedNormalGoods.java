package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesImportedNormalGoods implements TaxFees {

	@Override
	public double taxes(Product product) {
		if (product != null) {
			double taxes10;
			double taxes5;
			double taxes10Und5;

			taxes10 = (product.getNetPrice() * 10) / 100;
			taxes5 = (product.getNetPrice() * 5) / 100;
			taxes10Und5 = taxes10 + taxes5;

			return Utilites.round(taxes10Und5);
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

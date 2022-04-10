package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesImportedNormalGoods implements TaxFees {

	@Override
	public void preform(Product product) {
		if (product != null) {
			double taxes10;
			double taxes5;
			double taxes10Und5;

			double grossPrice;

			taxes10 = (product.getNetPrice() * 10) / 100;
			taxes5 = (product.getNetPrice() * 5) / 100;
			taxes10Und5 = taxes10 + taxes5;

			grossPrice = product.getNetPrice() + Utilites.round(taxes10Und5);

			product.setTaxFees(Utilites.round(taxes10Und5));
			product.setGrossPrice(Utilites.round2DigitAfterComma(grossPrice));
		}

	}

}

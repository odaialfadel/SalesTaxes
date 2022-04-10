package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesNormalGoods implements TaxFees {

	@Override
	public void preform(Product product) {

		if (product != null) {
			double taxes;
			double grossPrice;

			taxes = (product.getNetPrice() * 10) / 100;

			grossPrice = product.getNetPrice() + Utilites.round(taxes);

			product.setTaxFees(Utilites.round(taxes));
			product.setGrossPrice(Utilites.round2DigitAfterComma(grossPrice));
		}
	}

}

package app.model.taxType.taxesCalculation;

import app.model.Product;
import app.model.Utilites;
import app.model.taxType.TaxFees;

public class TaxesImportedExemptGoods implements TaxFees {

	@Override
	public void preform(Product product) {
		if (product != null) {
			double taxes5;
			double grossPrice;

			taxes5 = (product.getNetPrice() * 5) / 100;
			grossPrice = product.getNetPrice() + Utilites.round(taxes5);

			product.setTaxFees(Utilites.round(taxes5));
			product.setGrossPrice(Utilites.round2DigitAfterComma(grossPrice));
		}
	}

}

package model.taxType.taxesCalculation;

import model.Product;
import model.taxType.TaxFees;

public class Taxes10Precent implements TaxFees {

	@Override
	public void preformTaxes(Product product) {
		double taxes = 0;
		if (product != null) {
			taxes = (product.getNetPrice() * 10) / 100;

		}

	}

}

package model.taxType.taxesCalculation;

import model.Product;
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
		if (product != null) {
			return product.getNetPrice();
		}
		return 0;
	}

}

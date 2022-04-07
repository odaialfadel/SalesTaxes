package model.taxType.taxesCalculation;

import model.Product;
import model.Utilites;
import model.taxType.TaxFees;

public class TaxesNormalGoods implements TaxFees {

	@Override
	public double taxes(Product product) {
		double taxes = 0.00;
		if (product != null) {
			taxes = (product.getNetPrice() * 10) / 100;
			return Utilites.round(taxes);
		}
		return 0;
	}

	@Override
	public double grossPriceCalculation(Product product) {
		if (product != null) {
			return product.getNetPrice() + taxes(product);
		}
		return 0;
	}

}

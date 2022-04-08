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
		double grossPrice;
		if (product != null) {
			grossPrice = product.getNetPrice() + taxes(product);
			return Utilites.round2DigitAfterComma(grossPrice);

		}
		return 0;
	}

}

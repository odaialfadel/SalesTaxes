package model.taxType.taxesCalculation;

import model.Product;
import model.Utilites;
import model.taxType.TaxFees;

public class TaxesImportedExemptGoods implements TaxFees {

	@Override
	public double taxes(Product product) {
		double taxes5 = 0.00;
		if (product != null) {
			taxes5 = (product.getNetPrice() * 5) / 100;
			// System.err.println(Utilites.round(taxes5));
			return Utilites.round(taxes5);
		}
		return 0;
	}

	@Override
	public double grossPriceCalculation(Product product) {
		double grossPrice;
		if (product != null) {
			grossPrice = product.getNetPrice() + taxes(product);
			// System.out.println(Utilites.round2DigitAfterComma(grossPrice));
			return Utilites.round2DigitAfterComma(grossPrice);
		}
		return 0;
	}

}

package model.taxType.taxesCalculation;

import model.Product;
import model.Utilites;
import model.taxType.TaxFees;

public class TaxesImportedGoods implements TaxFees {

	@Override
	public double taxes(Product product) {
		double taxes10 = 0.00;
		double taxes5 = 0.00;
		if (product != null) {
			taxes10 = (product.getNetPrice() * 10) / 100;
			taxes5 = (product.getNetPrice() * 5) / 100;
			
			return Utilites.round(taxes10) + Utilites.round(taxes5);
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

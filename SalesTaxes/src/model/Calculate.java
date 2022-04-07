package model;

import model.taxType.TaxFees;
import model.taxType.taxesCalculation.TaxFree;
import model.taxType.taxesCalculation.TaxesImportedGoods;
import model.taxType.taxesCalculation.TaxesNormalGoods;

public class Calculate {

	public Product product;
	private String[] exemptProduct = { "book", "chocolate", "pills" };

	public Calculate(Product product) {
		this.product = product;
	}

	public void preform() {

		TaxFees taxes = null;

			if (product.getInfo().contains("imported")) {
				taxes = new TaxesImportedGoods();
			} else if (isExept()) {
				taxes = new TaxFree();
			} else {
				taxes = new TaxesNormalGoods();
			}

			product.setTaxFees(taxes.taxes(product));
			product.setGrossPrice(taxes.grossPriceCalculation(product));
	}

	private boolean isExept() {
		for (int i = 0; i < exemptProduct.length; i++) {
			if (product.getInfo().contains(exemptProduct[i])) {
				return true;
			}
		}
		return false;
	}

}

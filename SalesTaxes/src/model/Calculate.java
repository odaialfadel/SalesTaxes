package model;

import java.util.List;

import model.taxType.TaxFees;
import model.taxType.taxesCalculation.TaxFree;
import model.taxType.taxesCalculation.TaxesImportedExemptGoods;
import model.taxType.taxesCalculation.TaxesImportedNormalGoods;
import model.taxType.taxesCalculation.TaxesNormalGoods;

public class Calculate {





	public void preform(Product product) {
		TaxFees taxes = null;
		if (product != null) {

			if (product.getInfo().contains("import") && isExept(product)) {
				taxes = new TaxesImportedExemptGoods();
			} else if (product.getInfo().contains("import") && !isExept(product)) {
				taxes = new TaxesImportedNormalGoods();
		} else if (isExept(product)) {
			taxes = new TaxFree();
			} else {
			taxes = new TaxesNormalGoods();
			}

		product.setTaxFees(taxes.taxes(product));
		product.setGrossPrice(taxes.grossPriceCalculation(product));

	}
}

public double totalCostProducts(List<Product> productList) {
		double totalCosts = 0.00;
		for (Product product : productList) {
			totalCosts += product.getGrossPrice();
		}
		return totalCosts;
	}

	public double totalTaxesCollected(List<Product> productList) {
		double collectedTaxes = 0.00;
		for (Product product : productList) {
			collectedTaxes += product.getTaxFees();
		}
		return collectedTaxes;
	}

	private boolean isExept(Product product) {
		String[] exemptProduct = { "book", "chocolate", "pills" };
		for (int i = 0; i < exemptProduct.length; i++) {
			if (product.getInfo().contains(exemptProduct[i])) {
				return true;
			}
		}
		return false;
	}

}

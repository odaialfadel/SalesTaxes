package app.model;

import java.util.List;

import app.model.taxType.TaxFees;
import app.model.taxType.taxesCalculation.TaxFree;
import app.model.taxType.taxesCalculation.TaxesImportedExemptGoods;
import app.model.taxType.taxesCalculation.TaxesImportedNormalGoods;
import app.model.taxType.taxesCalculation.TaxesNormalGoods;

public class Calculate {

	TaxFees taxeFees;

	public TaxFees preform(Product product) {
		if (product != null) {

			if (product.getInfo().contains("import") && isExept(product)) {
				taxeFees = new TaxesImportedExemptGoods();
				return taxeFees;
			} else if (product.getInfo().contains("import") && !isExept(product)) {
				taxeFees = new TaxesImportedNormalGoods();
				return taxeFees;
			} else if (isExept(product)) {
				taxeFees = new TaxFree();
				return taxeFees;
			} else {
				taxeFees = new TaxesNormalGoods();
				return taxeFees;
			}
		}
		return null;
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
		String[] exemptProduct = { "book", "chocolate", "pills", "headache" };
		for (int i = 0; i < exemptProduct.length; i++) {
			if (product.getInfo().contains(exemptProduct[i])) {
				return true;
			}
		}
		return false;
	}

}

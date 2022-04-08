package app.model.taxType;

import app.model.Product;

public interface TaxFees {

	public double taxes(Product product);

	public double grossPriceCalculation(Product product);


}

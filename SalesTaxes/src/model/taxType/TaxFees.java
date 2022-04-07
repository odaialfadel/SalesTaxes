package model.taxType;

import java.util.List;

import model.Product;

public interface TaxFees {

	public void preformTaxes(List<Product> products);

}

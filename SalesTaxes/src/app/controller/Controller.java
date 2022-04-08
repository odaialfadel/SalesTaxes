package app.controller;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.TheModel;
import model.Utilites;
import view.TheView;

public class Controller {

	private TheModel model;
	private TheView view;
	List<Product> productList = new ArrayList<Product>();


	public Controller(TheModel model, TheView view) {
		this.model = model;
		this.view = view;
	}

	public void initController() {

		view.getAddProductButtun().addActionListener(e -> addProductToTextArea());
		view.getPrintReceiptButton().addActionListener(e -> printReceipt());


	}

	private void printReceipt() {
		if (productList != null) {

			for (Product product : productList) {
				System.out.println(product.getQuantity() + " " + product.getInfo() + ": " + product.getGrossPrice());
			}
			System.out.println("Sales Taxes: " + model.getCalculater().totalTaxesCollected(productList) + "\n"
					+ "Total: " + model.getCalculater().totalCostProducts(productList));
			view.getReceiptTextArea().setText("");
		}
	}

	private void addProductToTextArea() {

		double enteredPrice = Utilites.round2DigitAfterComma(Double.parseDouble(view.getProductPrice().getText()));
		double quantity = Utilites.round2DigitAfterComma(Double.parseDouble(view.getQuantityTextField().getText()));
		double grossPrice = 0;
		productList.add(new Product(view.getProductInfoField().getText(), enteredPrice));

		for (Product product : productList) {
			model.getCalculater().preform(product);
			product.setQuantity(quantity);
			grossPrice = product.getGrossPrice() * quantity;

		}
		view.getReceiptTextArea().setText(
				view.getReceiptTextArea().getText() + view.getProductInfoField().getText() + ": " + grossPrice + "\n");



		view.getProductInfoField().setText("");
		view.getProductPrice().setText("");
		view.getQuantityTextField().setText("");
	}

}

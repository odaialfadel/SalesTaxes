package app.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import app.model.Product;
import app.model.Receipt;
import app.model.TheModel;
import app.model.Utilites;
import app.view.TheView;

public class Controller {

	private TheModel model;
	private TheView view;

	private static final String PATH = "Output//";
	private static final File MYFILE = new File(PATH + "Receipt.txt");


	public Controller(TheModel model, TheView view) {
		this.model = model;
		this.view = view;
	}

	public void initController() {


		view.getAddProductButtun().addActionListener(e -> addProductToTextArea());

		view.getDeleteProducktButton().addActionListener(e -> deleteProduct());

		view.getPrintReceiptButton().addActionListener(e -> printReceipt());

		view.getOpenReceiptFolder().addActionListener(e -> openFolder());


	}


	private void openFolder() {
		try {
		if (!MYFILE.exists()) {
			MYFILE.getParentFile().mkdir();
			MYFILE.createNewFile();
			}
			Desktop.getDesktop().open(new File("Output//"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Folder doesen't Found or cannt be created!", "Error",
					JOptionPane.ERROR_MESSAGE);
				
		}
		
	}

	private void printReceipt() {
		if (!model.getProductList().isEmpty()) {
			try {
				if (!MYFILE.exists()) {
					MYFILE.getParentFile().mkdir();
					MYFILE.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(MYFILE);

				// Make Receipt
				model.setReceipt(new Receipt(model.getProductList(),
						model.getCalculater().totalTaxesCollected(model.getProductList()),
						model.getCalculater().totalCostProducts(model.getProductList())));

				view.getReceiptTextArea().setText("");
				view.getComboProductList().removeAllItems();

				System.out.println(model.getReceipt().receiptToString());

				fos.write(model.getReceipt().receiptToString().getBytes());

				model.getProductList().clear();
				view.getSalesTaxesLabel().setText("00.00");
				view.getTotalLabel().setText("00.00");

				fos.flush();
				fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "There is no products to print!", "Error", JOptionPane.ERROR_MESSAGE);
		}


	}

	// help method to show or delete product from Display
	private String productOnDisplay(Product product) {
		return product.getQuantity() + " " + product.getInfo() + ": " + product.getGrossPrice() + "\n";
	}

	private void addProductToTextArea() {

		String productInfoField = view.getProductInfoField().getText();
		String productPriceField = view.getProductPriceField().getText();
		String productQuantityField = view.getQuantityTextField().getText();

		if (!productInfoField.equals("") && !productPriceField.equals("") && !productQuantityField.equals("")) {

			double enteredPrice = Utilites.round2DigitAfterComma(Double.parseDouble(productPriceField));
			int quantity = Integer.parseInt(productQuantityField);

			// String productInfo = view.getProductInfoField().getText();
			Product productToAdd = new Product(productInfoField, enteredPrice);
		
		double taxFees = model.getCalculater().preform(productToAdd).taxes(productToAdd);
		double grossPrice = model.getCalculater().preform(productToAdd).grossPriceCalculation(productToAdd);



		Product product = new Product(productInfoField, enteredPrice, grossPrice, taxFees, quantity);
		
		// add Product to the List
		model.getProductList().add(product);

		// show Product on Display
		view.getReceiptTextArea().setText(view.getReceiptTextArea().getText() + productOnDisplay(product));
		
		showSalestaxAndTotalOnDisplay();
		
		// add productinfo to the Combobox
		view.getComboProductList().addItem(productInfoField);


		view.getProductInfoField().setText("");
		view.getProductPriceField().setText("");
		view.getQuantityTextField().setText("");
	} else {
		JOptionPane.showMessageDialog(null, "You didnt enter any product or you did not fill all required fields!",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	}

	/**
	 * show tax collected and total price now on Display
	 */
	private void showSalestaxAndTotalOnDisplay() {

		double salesTaxes = 0;
		double totalPrice = 0;
		for (Product prod : model.getProductList()) {
			salesTaxes += prod.getTaxFees();
			totalPrice += prod.getGrossPrice();
		}
		salesTaxes = Utilites.round2DigitAfterComma(salesTaxes);
		totalPrice = Utilites.round2DigitAfterComma(totalPrice);
		view.getSalesTaxesLabel().setText(salesTaxes + "");
		view.getTotalLabel().setText(totalPrice + "");
	}

	private void deleteProduct() {

		if (view.getComboProductList().getSelectedIndex() != -1
				|| view.getComboProductList().getSelectedItem() != null) {

			// remove from the List
			String productInfo = String.valueOf(view.getComboProductList().getSelectedItem());
			Product product = findProductByInfo(productInfo);
			model.getProductList().remove(findProductByInfo(productInfo));

			// remove from the combobox
			view.getComboProductList().removeItem(view.getComboProductList().getSelectedItem());

			// delete Product from Display
			view.getReceiptTextArea()
					.setText(view.getReceiptTextArea().getText().replaceAll(productOnDisplay(product), ""));

			// recalculate after deletion
			double collectedTaxes = Double.parseDouble(view.getSalesTaxesLabel().getText()) - product.getTaxFees();
			double totalNow = Double.parseDouble(view.getTotalLabel().getText()) - product.getGrossPrice();

			collectedTaxes = Utilites.round2DigitAfterComma(collectedTaxes);
			totalNow = Utilites.round2DigitAfterComma(totalNow);

			view.getSalesTaxesLabel().setText(collectedTaxes + "");
			view.getTotalLabel().setText(totalNow + "");
		} else {
			JOptionPane.showMessageDialog(null, "There is nothing selected to delete!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// to delete specifec Product from the List
	private Product findProductByInfo(String info) {
		for (Product product : model.getProductList()) {
			if (info.equals(product.getInfo())) {
				return product;
			}
		}
		return null;
	}

}

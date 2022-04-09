package app.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import app.model.Product;
import app.model.Receipt;
import app.model.TheModel;
import app.model.Utilites;
import app.view.TheView;

public class Controller {

	private TheModel model;
	private TheView view;
	// private List<Product> productList = new ArrayList<Product>();
	private static final String PATH = "Output//Receipt.txt";
	private static final File MYFILE = new File(PATH);


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
			} catch (IOException e) {
				e.printStackTrace();

		}
		
	}

	private void printReceipt() {
		if (model.getProductList() != null) {
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
		}


	}

	// help method to show or delete product from Display
	private String productOnDisplay(Product product) {
		return product.getQuantity() + " " + product.getInfo() + ": " + product.getGrossPrice() + "\n";
	}

	private void addProductToTextArea() {

		if (!view.getProductInfoField().getText().equals("")) {

		double enteredPrice = Utilites.round2DigitAfterComma(Double.parseDouble(view.getProductPrice().getText()));
		int quantity = Integer.parseInt(view.getQuantityTextField().getText());

		String productInfo = view.getProductInfoField().getText();
		Product productToAdd = new Product(productInfo, enteredPrice);
		
		double taxFees = model.getCalculater().preform(productToAdd).taxes(productToAdd);
		double grossPrice = model.getCalculater().preform(productToAdd).grossPriceCalculation(productToAdd);



		Product product = new Product(productInfo, enteredPrice, grossPrice, taxFees, quantity);
		
		// add Product to the List
		model.getProductList().add(product);

		// show Product on Display
		view.getReceiptTextArea().setText(view.getReceiptTextArea().getText() + productOnDisplay(product));
		
		// show tax collected and total price now on Display
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
		
		// add productinfo to the Combobox
		view.getComboProductList().addItem(productInfo);
		// System.err.println(product.getInfo() + ": " + product.getNetPrice() + ", " +
		// product.getGrossPrice());

		view.getProductInfoField().setText("");
		view.getProductPrice().setText("");
		view.getQuantityTextField().setText("");
	}
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

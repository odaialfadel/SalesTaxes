package app.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import model.Product;
import model.Receipt;
import model.TheModel;
import model.Utilites;
import view.TheView;

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





	private void deleteProduct() {
		if (view.getComboProductList().getSelectedIndex() != -1
				|| view.getComboProductList().getSelectedItem() != null) {
//			// remove from the List
			String productInfo = String.valueOf(view.getComboProductList().getSelectedItem());
			model.getProductList().remove(findProductByInfo(productInfo));
			// remove from the combobox

			//remove from TextArea
//			view.getReceiptTextArea().setText(view.getReceiptTextArea().getText().replaceAll(
//					findProductByInfo(productInfo).getInfo() + ": " + findProductByInfo(productInfo).getGrossPrice(),
//					""));
			view.getComboProductList().removeItem(view.getComboProductList().getSelectedItem());
		}
	}

	private Product findProductByInfo(String info) {
		for (Product product : model.getProductList()) {
			if (info.equals(product.getInfo())) {
				return product;
			}
		}
		return null;
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
				fos.flush();
				fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

	private String showInTextArea(String infoData) {
		return view.getReceiptTextArea().getText() + infoData + "\n";
	}

	private void addProductToTextArea() {

		if (!view.getProductInfoField().getText().equals("")) {

		double enteredPrice = Utilites.round2DigitAfterComma(Double.parseDouble(view.getProductPrice().getText()));
		int quantity = Integer.parseInt(view.getQuantityTextField().getText());
		double grossPrice = 0;
		model.getProductList().add(new Product(view.getProductInfoField().getText(), enteredPrice));
		for (Product product : model.getProductList()) {
			model.getCalculater().preform(product);
			product.setQuantity(quantity);
			grossPrice = product.getGrossPrice() * quantity;
		}

		view.getReceiptTextArea().setText(showInTextArea(
				view.getQuantityTextField().getText() + " " + view.getProductInfoField().getText() + ": "
						+ grossPrice));

		view.getComboProductList().addItem(view.getProductInfoField().getText());
		view.getProductInfoField().setText("");
		view.getProductPrice().setText("");
		view.getQuantityTextField().setText("");
	}
	}

}

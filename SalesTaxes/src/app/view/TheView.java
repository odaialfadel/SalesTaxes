package app.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class TheView extends JFrame {

	private JTextField productInfoField, productPriceField, quantityTextField;
	private JButton addProductButtun, printReceiptButton, openReceiptFolder, deleteProducktButton;
	private JTextArea receiptTextArea;
	private JComboBox<String> comboProductList;
	private JLabel salesTaxesLabel, totalLabel;

	/**
	 * Create the Window.
	 */
	public TheView() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 516, 310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		productInfoField = new JTextField();
		productInfoField.setBounds(10, 62, 119, 20);
		getContentPane().add(productInfoField);
		productInfoField.setColumns(10);

		productPriceField = new JTextField();
		productPriceField.setBounds(139, 62, 58, 20);
		getContentPane().add(productPriceField);
		productPriceField.setColumns(10);

		addProductButtun = new JButton("add");
		addProductButtun.setBounds(194, 95, 70, 20);
		getContentPane().add(addProductButtun);

		JPanel viewtPanel = new JPanel();
		viewtPanel.setLayout(null);
		viewtPanel.setOpaque(false);
		viewtPanel.setForeground(Color.GRAY);
		viewtPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewtPanel.setBackground(Color.LIGHT_GRAY);
		viewtPanel.setBounds(275, 11, 215, 239);
		getContentPane().add(viewtPanel);

		JLabel receiptView = new JLabel("Receipt");
		receiptView.setOpaque(false);
		receiptView.setBounds(26, 11, 60, 18);
		viewtPanel.add(receiptView);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(10, 34, 195, 145);
		viewtPanel.add(scrollPane);

		receiptTextArea = new JTextArea();
		
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		viewtPanel.add(scrollPane);
		scrollPane.setViewportView(receiptTextArea);
		receiptTextArea.setOpaque(false);
		receiptTextArea.setLineWrap(true);
		receiptTextArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		receiptTextArea.setEditable(false);

		JLabel label = new JLabel("Sales Taxes:");
		label.setBounds(10, 190, 76, 14);
		viewtPanel.add(label);

		JLabel label2 = new JLabel("Total:");
		label2.setBounds(10, 214, 76, 14);
		viewtPanel.add(label2);

		salesTaxesLabel = new JLabel("00.00");
		salesTaxesLabel.setBounds(93, 190, 63, 14);
		viewtPanel.add(salesTaxesLabel);

		totalLabel = new JLabel("00.00");
		totalLabel.setBounds(93, 214, 63, 14);
		viewtPanel.add(totalLabel);

		printReceiptButton = new JButton("Print Receipt");
		printReceiptButton.setBounds(28, 193, 114, 23);
		getContentPane().add(printReceiptButton);

		JLabel productInfoLable = new JLabel("Enter your Product");
		productInfoLable.setBounds(10, 43, 119, 14);
		getContentPane().add(productInfoLable);

		JLabel productPrice = new JLabel("Price");
		productPrice.setBounds(139, 43, 58, 14);
		getContentPane().add(productPrice);

		JLabel quantityLable = new JLabel("Quantity");
		quantityLable.setBounds(207, 43, 46, 14);
		getContentPane().add(quantityLable);

		quantityTextField = new JTextField();
		quantityTextField.setBounds(207, 62, 46, 20);
		getContentPane().add(quantityTextField);
		quantityTextField.setColumns(10);

		openReceiptFolder = new JButton("Receipt Folder");
		openReceiptFolder.setBounds(152, 193, 101, 23);
		getContentPane().add(openReceiptFolder);

		deleteProducktButton = new JButton("Delete");
		deleteProducktButton.setBounds(117, 95, 70, 20);
		getContentPane().add(deleteProducktButton);

		comboProductList = new JComboBox<String>();
		comboProductList.setBounds(10, 93, 97, 22);
		getContentPane().add(comboProductList);

		setVisible(true);
	}

	public JTextArea getReceiptTextArea() {
		return receiptTextArea;
	}

	public void setReceiptTextArea(JTextArea receiptTextArea) {
		this.receiptTextArea = receiptTextArea;
	}

	public JTextField getProductInfoField() {
		return productInfoField;
	}

	public JTextField getProductPriceField() {
		return productPriceField;
	}

	public JButton getAddProductButtun() {
		return addProductButtun;
	}

	public JButton getOpenReceiptFolder() {
		return openReceiptFolder;
	}

	public JButton getPrintReceiptButton() {
		return printReceiptButton;
	}

	public JTextField getQuantityTextField() {
		return quantityTextField;
	}

	public JButton getDeleteProducktButton() {
		return deleteProducktButton;
	}

	public JComboBox<String> getComboProductList() {
		return comboProductList;
	}

	public JLabel getSalesTaxesLabel() {
		return salesTaxesLabel;
	}

	public JLabel getTotalLabel() {
		return totalLabel;
	}
}

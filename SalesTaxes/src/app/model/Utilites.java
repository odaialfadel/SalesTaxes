package app.model;

import java.text.DecimalFormat;

public class Utilites {

	public static double round(double price) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		double temp = price / 0.05;
		// to round up
		temp = Math.ceil(temp);
		temp = temp * 0.05;
		return Double.valueOf(decimalFormat.format(temp).replace(',', '.'));
	}

	public static double round2DigitAfterComma(double number) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return Double.valueOf(decimalFormat.format(number).replace(',', '.'));
	}





}

package app.model;

import java.text.DecimalFormat;

public class Utilites {

	public static double round(double price) {
		double temp = price / 0.05;
		temp = Math.ceil(temp);
		temp = temp * 0.05;
		return temp;
	}

	public static double round2DigitAfterComma(double number) {
//		return (int) (Math.round(number * 100)) / 100.0;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return Double.valueOf(decimalFormat.format(number).replace(',', '.'));
	}




}

package model;

public class Utilites {

	public static double round(double price) {
		return Math.round(price * 20.0) / 20.0;
	}

	public static double round2DigitAfterComma(double number) {
		return (int) (Math.round(number * 100)) / 100.0;
	}




}

package refactoring.pricie;

import refactoring.dto.Movie;

public class RegularPrice extends Price{

	@Override
	public 	int getPriceCode() {
		return REGULAR;
	}
	
	public double getCharge(int daysRented) {
		// 1.일반물(2일)2000원,일일초과당1500원,적립1
		double result = 2000;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1500;
		}
		return result;
	}

}

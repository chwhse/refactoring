package refactoring.pricie;

import refactoring.dto.Movie;

public class ChildrenPrice extends Price {

	@Override
	public	int getPriceCode() {
		return CHILDREN;
	}
	
	public double getCharge(int daysRented) {
		// 2.아동물(3일)1500원,일일초과당1500,적립1
		double result = 1500;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1500;
		}
		return result;
	}
}

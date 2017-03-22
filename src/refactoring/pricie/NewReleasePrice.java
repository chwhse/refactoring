package refactoring.pricie;

import refactoring.dto.Movie;

public class NewReleasePrice extends Price {

	@Override
	public	int getPriceCode() {
		return NEW_RELEASE;
	}
	
	public double getCharge(int daysRented) {
		// 3.최신물(1일)3000원, 일일초과 3000,적립1+1
		double result = 2000;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1500;
		}
		return result;
	}
	
	@Override
	public int getFrequentRentalPoints(int daysRented) {
		return daysRented>1?2:1;
	}
}

package refactoring.pricie;

public class AdultPrice extends Price {

	@Override
	public int getPriceCode() {
		return ADULT;
	}

	@Override
	public double getCharge(int daysRented) {
		double result = 0;
		result = daysRented*5000;
		return result;
	}

	@Override
	public int getFrequentRentalPoints(int daysRented) {
		return daysRented>1?3:2;
	}
	
	
}

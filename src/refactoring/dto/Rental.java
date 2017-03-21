package refactoring.dto;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge(){
		return getMovie().getCharge(daysRented);
	}

	public double getFrequentRentalPoints(){
		return getMovie().getFrequentRentalPoints(daysRented);
	}
}
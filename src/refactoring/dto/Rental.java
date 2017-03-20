package refactoring.dto;

public class Rental {
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) {
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
			
		// 1.일반물(2일)2000원, 일일초과 1500원 , 적립1 => (2일,3000원) 일일초과 2000원, 적립0.5
		// 2.아동물(3일)1500원, 일일초과 1500원, 적립1 => (2일,2000원) 일일초과 1500원, 적립1
		// 3.최신물(1일)3000원, 일일초과 3000원, 적립2 => (2일,4000원) 일일초과 4000원, 적립1+1
		double result = 0;
		Movie movie = getMovie();
		int priceCode = movie.getPriceCode();
		int daysRented = getDaysRented();
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			result += 3000;
			if(daysRented>2)
				result += (daysRented-2)*2000;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented*4000;
			break;
		case Movie.CHILDRENS:
			result += 2000;
			if(daysRented>3){
				result += (daysRented-3)*1500;
			}
			break;
		}
		return result;
		
	}
	
	
}

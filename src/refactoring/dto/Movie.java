package refactoring.dto;

import refactoring.pricie.ChildrenPrice;
import refactoring.pricie.NewReleasePrice;
import refactoring.pricie.Price;
import refactoring.pricie.PriceFactory;
import refactoring.pricie.RegularPrice;

public class Movie {
	
	
	private String title;
	private Price price;
	
	
	public Movie(String title, int priceCode) {		
		this.title = title;
		setPriceCode(priceCode);
	}
	public int getPriceCode() {
		return price.getPriceCode();
	}
	public void setPriceCode(int priceCode) {
		price = PriceFactory.getPrice(priceCode);
	}
	public String getTitle() {
		return title;
	}
	
	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
	
	public int getFrequentRentalPoints(int daysRented) {
		return price.getFrequentRentalPoints(daysRented);
	}
}

package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public void addRentals(Rental aRental) {
		this.rentals.add(aRental);
	}
	public String getName() {
		return name;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		StringBuilder sb = new StringBuilder(getName()+"고객님의 대여기록 \n");
		
		for(Rental each:rentals){
			double thisAmount = 0;	// 1.일반물(2일)2000원, 일일초과 1500원 , 적립1
									// 2.아동물(3일)1500원, 일일초과 1500원, 적립1
									// 3.최신물(1일)3000원, 일일초과 3000원, 적립2
			Movie movie = each.getMovie();
			int priceCode = movie.getPriceCode();
			int daysRented = each.getDaysRented();
			switch (priceCode) {
			case Movie.REGULAR:
				thisAmount += 2000;
				if(daysRented>2)
					thisAmount += (daysRented-2)*1500;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += daysRented*3000;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1500;
				if(daysRented>3){
					thisAmount += (daysRented-3)*1500;
				}
				break;
			}
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE && each.getDaysRented() > 1){
				frequentRenterPoints++;
			}
			
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), thisAmount));
			
			totalAmount += thisAmount;
		}	// for loop
		
		sb.append(String.format("누적 대여료 : %s%n적립 포인트: %s%n", totalAmount, frequentRenterPoints));
		
		return sb.toString();
	}
	
	
	
}

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
			double thisAmount = 0;	
			// 1.일반물(2일)2000원, 일일초과 1500원 , 적립1 => (2일,3000원) 일일초과 2000원, 적립0.5
			// 2.아동물(3일)1500원, 일일초과 1500원, 적립1 => (2일,2000원) 일일초과 1500원, 적립1
			// 3.최신물(1일)3000원, 일일초과 3000원, 적립2 => (2일,4000원) 일일초과 4000원, 적립1+1
			// HTML형식으로 출력 원함.
			Movie movie = each.getMovie();
			int priceCode = movie.getPriceCode();
			int daysRented = each.getDaysRented();
			switch (priceCode) {
			case Movie.REGULAR:
				thisAmount += 3000;
				if(daysRented>2)
					thisAmount += (daysRented-2)*2000;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += daysRented*4000;
				break;
			case Movie.CHILDRENS:
				thisAmount += 2000;
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
	
	public String htmlStatement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		StringBuilder sb = new StringBuilder("<h1><Em>"+getName()+"고객님의 대여기록 </Em></h1><br>");
		
		for(Rental each:rentals){
			double thisAmount = 0;	
			// 1.일반물(2일)2000원, 일일초과 1500원 , 적립1 => (2일,3000원) 일일초과 2000원, 적립0.5
			// 2.아동물(3일)1500원, 일일초과 1500원, 적립1 => (2일,2000원) 일일초과 1500원, 적립1
			// 3.최신물(1일)3000원, 일일초과 3000원, 적립2 => (2일,4000원) 일일초과 4000원, 적립1+1
			// HTML형식으로 출력 원함.
			Movie movie = each.getMovie();
			int priceCode = movie.getPriceCode();
			int daysRented = each.getDaysRented();
			switch (priceCode) {
			case Movie.REGULAR:
				thisAmount += 3000;
				if(daysRented>2)
					thisAmount += (daysRented-2)*2000;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += daysRented*4000;
				break;
			case Movie.CHILDRENS:
				thisAmount += 2000;
				if(daysRented>3){
					thisAmount += (daysRented-3)*1500;
				}
				break;
			}
			frequentRenterPoints++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE && each.getDaysRented() > 1){
				frequentRenterPoints++;
			}
			
			sb.append(String.format("nbsp;nbsp;%s nbsp;nbsp; %s<br>", each.getMovie().getTitle(), thisAmount));
			
			totalAmount += thisAmount;
		}	// for loop
		
		sb.append(String.format("누적 대여료 : <Em>%s</Em><br><p>적립 포인트: <Em>%s</Em><br>", totalAmount, frequentRenterPoints));
		
		return sb.toString();
	}
	
	
}

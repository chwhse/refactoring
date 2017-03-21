package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRentals(Rental aRental) {
		this.rentals.add(aRental);
	}
	public String getName() {
		return name;
	}
	
	public String statement(){	//대여료와 적립포인트 출력
		double totalAmount = 0;
		int frequentRenterPoints = 0;	//적립포인트
		StringBuilder sb = new StringBuilder();
		sb.append(getName()+"고객님의 대여기록 \n");
		
		for(Rental each:rentals){
			frequentRenterPoints += getFreQuentRentalPoints();
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge()));
		}	// for loop
		
		sb.append(String.format("누적 대여료 : %s%n적립 포인트: %s%n", getTotalCharge(), frequentRenterPoints));
		
		return sb.toString();
	}

	private int getFreQuentRentalPoints() {
		int result = 0;
		for(Rental each:rentals){
			result += each.getCharge();
		}
		return result;
	}

	private Object getTotalCharge() {
		double result = 0;
		for(Rental each:rentals){
			result += each.getCharge();
		}
		return result;
		
	}

	
	
}

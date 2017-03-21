package refactoring.statement;

import refactoring.dto.Customer;
import refactoring.dto.Rental;

public class HtmlStatement extends Statement {
	@Override
	protected String footerString(Customer customer) {
		return String.format("<p>누적대여료 : <em>%s</em>%n<p>적립 포인트 : <em>%s</em>%n", customer.getTotalCharge(),
				customer.getTotalfrequentRanterPoints());
	}
	@Override
	protected String eachRentalString(Rental each) {
		return String.format("\t%s \t %s%n", each.getMovie().getTitle(), each.getCharge());
	}
	@Override
	protected String headerString(String customerName){
		return "<h1><em>"+customerName +"고객님의 대여기록 </em></h1></p>\n";
	}
}

package refactoring.pricie;

import refactoring.dto.Movie;

public class PriceFactory {
	public static Price getPrice(int priceCode){
		Price price = null;
		switch (priceCode) {
		case Price.CHILDREN:
			price = new ChildrenPrice();
			break;
		case Price.REGULAR:
			price = new RegularPrice();
			break;
		case Price.NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case Price.ADULT:
			price = new AdultPrice();
			break;
		default:
			throw new IllegalArgumentException("가격코드가잘못입력됨");
		}
		return price;
	}
}

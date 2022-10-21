import java.text.ParseException;
import java.util.Scanner;

public class Buyer extends Person {

	public Offering showMenu(Facade facade) throws ParseException {
		System.out.println("Buyer");
		ProductIterator productIterator;
		productIterator = facade.getTheProductList().getProductIterator();
		ProductMenu productMenu;
		if(facade.getnProductCategory() == 1) {
			productMenu = new MeatProductMenu();
		} else {
			productMenu = new ProduceProductMenu();
		}
		productMenu.setProductList(facade.getTheProductList());
		productMenu.showMenu();
		return productMenu.showAddButton();
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}

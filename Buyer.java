import java.util.Scanner;

public class Buyer extends Person {

	public void showMenu(Facade facade) {
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
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}

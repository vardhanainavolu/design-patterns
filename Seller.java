import java.text.ParseException;

public class Seller extends Person {

	public Offering showMenu(Facade facade) throws ParseException {
		System.out.println("Seller");
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

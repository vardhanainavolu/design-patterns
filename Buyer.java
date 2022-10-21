import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Buyer extends Person {

	public Offering showMenu(Facade facade) throws ParseException {

//		if(facade.getnProductCategory() == 1) {
//			productMenu = new MeatProductMenu();
//		} else {
//			productMenu = new ProduceProductMenu();
//		}
//		productMenu.setProductList(facade.getTheProductList());
//		productMenu.showMenu();
//		return productMenu.showAddButton();
		return null;
	}
	 public OfferingList showAddButton(Facade facade) throws ParseException
	 {
		 System.out.println("Buyer");
		 OfferingList offeringList = facade.getOfferingList();
		 if(offeringList == null) {
			 offeringList = new OfferingList();
		 }
		 OfferingIterator offeringIterator = offeringList.getOfferingIterator();
		 Integer cnt = 0;
		 boolean flag = false;
		 HashMap<Integer, OfferingIterator> mp = new HashMap<Integer, OfferingIterator>();
		 while(offeringIterator != null) {
			 System.out.println("Press "+cnt+ ": to bid for "+offeringIterator.getOffering().getProduct().getProductName()+" by "+offeringIterator.getOffering().getPerson().getUser()+" which closes at "+offeringIterator.getOffering().getBidCloseDate());
			 mp.put(cnt, offeringIterator);
			 offeringIterator = offeringIterator.Next();
			 cnt++;
			 flag = true;
		 }
		 offeringIterator = offeringList.getOfferingIterator();
		 Scanner read = new Scanner(System.in);
		 for(int i = 0; i < cnt-1; ++i) {
			 offeringIterator = offeringIterator.Next();
			 if(offeringList == null) {
				 System.out.println("Selection is out of bounds");
				 break;
			 }
		 }
		 if(flag == false) {
			 System.out.println("No products in the selected field");
			 return null;
		 }
		 Integer selection = read.nextInt();
		 System.out.println("Enter the bid amount");
		 Integer bid = read.nextInt();
		 offeringIterator.getOffering().addBids(facade.getUserInfoItem(), bid);
		 System.out.println("Bid sucessfully placed!");
		 return offeringList;
	 }	public ProductMenu CreateProductMenu() {
		return null;
	}

}

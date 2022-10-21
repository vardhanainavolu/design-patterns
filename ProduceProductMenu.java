import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ProduceProductMenu implements ProductMenu {

	private ClassProductList productList;
	public void showMenu() {
		ProductIterator productIterator = productList.getProductIterator();
		int cnt = 0;
		while(productIterator != null) {
			if(productIterator.getProduct().isProductType() == false) {
				System.out.println(cnt+":"+productIterator.getProduct().getProductName());
			}
			productIterator = productIterator.Next();
			cnt++;
		}
	}

	public Offering showAddButton() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the product key to select the product");
		Integer selection = scanner.nextInt();
		ProductIterator productIterator = productList.getProductIterator();
		for(int i = 0; i < selection; ++i) {
			productIterator = productIterator.Next();
			if(productIterator == null) {
				System.out.println("Selection is not in the list");
				break;
			}
		}
		Product product = productIterator.getProduct();
		System.out.println("Enter the bid close date for "+product.getProductName()+" in DD-MM-YYYY");
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String date = scanner.next();
		System.out.println(ft.parse(date));
		Offering offering = new Offering(product, ft.parse(date));
		return offering;
	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showViewButton() {

	}

	public void showComboxes() {

	}

	public void setProductList(ClassProductList productList) {
		this.productList = productList;
	}
}

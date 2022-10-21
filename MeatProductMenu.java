public class MeatProductMenu implements ProductMenu {

	private ClassProductList productList;
	public void showMenu() {
		ProductIterator productIterator = productList.getProductIterator();
		while(productIterator != null) {
			if(productIterator.getProduct().isProductType()) {
				System.out.println(productIterator.getProduct().getProductName());
			}
			productIterator = productIterator.Next();
		}
	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

	public void setProductList(ClassProductList productList) {
		this.productList = productList;
	}
}

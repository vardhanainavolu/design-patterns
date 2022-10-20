public class ProduceProductMenu implements ProductMenu {

	private ClassProductList productList;
	public void showMenu() {
		ProductIterator productIterator = productList.getProductIterator();
		if(productIterator == null) {
			productIterator = new ProductIterator();
		}
		while(productIterator.hasNext()) {
			if(productIterator.getProduct().isProductType() == false) {
				System.out.println(productIterator.getProduct().getProductName());
			}
			productIterator = productIterator.Next();
		}
	}

	public void showAddButton() {

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

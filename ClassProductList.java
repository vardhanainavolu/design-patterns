public class ClassProductList {

	private ProductIterator productIterator;

	public ProductIterator getProductIterator() {
		return productIterator;
	}

	public void setProductIterator(ProductIterator productIterator) {
		this.productIterator = productIterator;
	}

	public ClassProductList(ProductIterator productIterator) {
		setProductIterator(productIterator);
	}

	public void accept(NodeVisitor visitor) {

	}

	public void createNewProduct(Product product) {
		ProductIterator iterator = getProductIterator();
		ProductIterator newElement = new ProductIterator();
		newElement.setProduct(product);
		if(iterator.hasNext()) {
			newElement.setNext(iterator);
		}
		iterator.setHasNext(true);
		System.out.println(newElement.getProduct().getProductName());
		if(newElement.hasNext())
			System.out.println(" next:"+newElement.Next().getProduct().getProductName());
		this.setProductIterator(newElement);
	}

}

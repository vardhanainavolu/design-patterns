public class ProductIterator {

	private ClassProductList classProductList;

	private Product product;

	public ProductIterator() {
		hasNext = false;
	}

	private Boolean hasNext;

	private ProductIterator next;

	public void setNext(ProductIterator next) {
		this.next = next;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean hasNext() {
		return hasNext;
	}

	public ProductIterator Next() {
		return next;
	}



	public void MoveToHead() {

	}

	public void Remove() {

	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}
}

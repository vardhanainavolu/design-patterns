public class OfferingIterator {

	private OfferingList offeringList;

	private Offering offering;

	private OfferingIterator offeringIterator;

	public boolean hasNext() {
		return false;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

	public Offering getOffering() {
		return offering;
	}

	public void setOffering(Offering offering) {
		this.offering = offering;
	}

	public OfferingIterator Next() {
		return offeringIterator;
	}

	public void setNext(OfferingIterator offeringIterator) {
		this.offeringIterator = offeringIterator;
	}
}

public class OfferingList {

	private OfferingIterator offeringIterator;

	public void createNewOffering(Offering offering) {
		OfferingIterator newOffer = new OfferingIterator();
		newOffer.setOffering(offering);
		newOffer.setNext(offeringIterator);
		this.setOfferingIterator(newOffer);
	}

	public OfferingIterator getOfferingIterator() {
		return offeringIterator;
	}

	public void setOfferingIterator(OfferingIterator offeringIterator) {
		this.offeringIterator = offeringIterator;
	}
}

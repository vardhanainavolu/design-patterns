import java.util.ArrayList;
import java.util.*;
import java.util.Objects;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	public void visitProduct(Product product) {

	}

	public void visitTrading(Trading trading) {

	}

	public Object [] visitFacade(Facade facade) {
		OfferingList offeringList = facade.getOfferingList();
		OfferingIterator offeringIterator = offeringList.getOfferingIterator();
		Offering offering = null, earlyOffer = null;
		OfferingIterator prevOffer = null;
		Date date = new Date(2300, 12, 12);
		while(offeringIterator != null) {
			offering = offeringIterator.getOffering();
			if(date.compareTo(offering.getBidCloseDate()) < 0) {
				date = offering.getBidCloseDate();
				earlyOffer = offering;
			}
		}
		offeringIterator = offeringList.getOfferingIterator();
		if(earlyOffer == offeringIterator.getOffering()) {
			offeringList.setOfferingIterator(offeringIterator.Next());
		} else {
			while (earlyOffer != null && offeringIterator.getOffering() != earlyOffer) {
				prevOffer = offeringIterator;
				offeringIterator = offeringIterator.Next();
			}
			prevOffer.setNext(offeringIterator.Next());
		}
		return new Object []{offeringList, earlyOffer.getPerson()};
	}

}

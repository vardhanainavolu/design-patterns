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
//		System.out.println("Inside facade");
		OfferingList offeringList = facade.getOfferingList();
		if(offeringList == null) {
			offeringList = new OfferingList();
		}
		OfferingIterator offeringIterator = offeringList.getOfferingIterator();
		Offering offering = null, earlyOffer = null;
		OfferingIterator prevOffer = null;
		Date date = new Date(2300, 12, 12);
		while(offeringIterator != null) {
			offering = offeringIterator.getOffering();
			if(date.compareTo(offering.getBidCloseDate()) > 0) {
				date = offering.getBidCloseDate();
				earlyOffer = offering;
			}
			offeringIterator = offeringIterator.Next();
		}
//		if(earlyOffer != null)
//			System.out.println("Inside facade 2:"+earlyOffer.getProduct().getProductName());
		offeringIterator = offeringList.getOfferingIterator();
		if(offeringIterator == null) {
			return new Object[] {offeringList, null};
		}
		if(earlyOffer == offeringIterator.getOffering()) {
//			System.out.println("Inside facade 3:"+earlyOffer.getProduct().getProductName());
			offeringList.setOfferingIterator(offeringIterator.Next());
		} else {
			while (earlyOffer != null && offeringIterator.getOffering() != earlyOffer) {
				prevOffer = offeringIterator;
				offeringIterator = offeringIterator.Next();
			}
			prevOffer.setNext(offeringIterator.Next());
		}
//		System.out.println("Inside facade 3");
		if(earlyOffer == null) {
			return new Object[]{offeringList, null};
		}
		ArrayList<Object []> bids = earlyOffer.getBids();
		Integer min = 1000000;
		UserInfoItem target = null;
//		System.out.println(bids.size());
		for(int i = 0; i < bids.size(); ++i) {
//			System.out.println((Integer)(bids.get(i))[1]);
			if(((Integer)(bids.get(i))[1] < min)) {
				min = (Integer) (bids.get(i))[1];
				target = (UserInfoItem) (bids.get(i))[0];
			}
		}
//		if(target != null)
//			System.out.println("Inside facade 4:"+target.getUser());
		return new Object []{offeringList, target, earlyOffer.getProduct()};
	}

}

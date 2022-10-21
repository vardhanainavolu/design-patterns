import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Offering {

    private Product product;

    private Date bidCloseDate;

    private UserInfoItem person;

    private ArrayList<Object[]> bids = new ArrayList<>();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getBidCloseDate() {
        return bidCloseDate;
    }

    public void setBidCloseDate(Date bidCloseDate) {
        this.bidCloseDate = bidCloseDate;
    }

    public Offering(Product product, Date bidCloseDate) {
        this.product = product;
        this.bidCloseDate = bidCloseDate;
    }

    public UserInfoItem getPerson() {
        return person;
    }

    public void setPerson(UserInfoItem person) {
        this.person = person;
    }

    public ArrayList<Object[]> getBids() {
        return bids;
    }

    public void addBids(UserInfoItem user, Integer bid) {
        this.bids.add(new Object[] {user, bid});
    }
}

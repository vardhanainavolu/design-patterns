import java.util.Date;

public class Offering {

    private Product product;

    private Date bidCloseDate;

    private UserInfoItem person;

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
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Facade {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Product getTheSelectedProduct() {
		return theSelectedProduct;
	}

	public void setTheSelectedProduct(Product theSelectedProduct) {
		this.theSelectedProduct = theSelectedProduct;
	}

	public int getnProductCategory() {
		return nProductCategory;
	}

	public void setnProductCategory(int nProductCategory) {
		this.nProductCategory = nProductCategory;
	}

	public ClassProductList getTheProductList() {
		return theProductList;
	}

	public void setTheProductList(ClassProductList theProductList) {
		this.theProductList = theProductList;
	}

	public Person getThePerson() {
		return thePerson;
	}

	public void setThePerson(Person thePerson) {
		this.thePerson = thePerson;
	}

	public boolean login(String userName, String pwd, ArrayList<UserInfoItem> users) {
		UserInfoItem user;
		for(int i = 0; i < users.size(); ++i) {
			user = users.get(i);
			if(user.getUser().equals(userName)) {
				if(user.getPassword().equals(pwd)) {
					if(user.isState() == false) {
						this.setThePerson(new Buyer());
					} else {
						this.setThePerson(new Seller());
					}
					System.out.println("Successfully logged in!");
					return true;
				}
			}
		}
		return false;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public void SelectProduct() {

	}

	public void productOperation() {

	}

}

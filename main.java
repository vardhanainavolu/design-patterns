import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static UserInfoItem Login(Facade facade, ArrayList<UserInfoItem> users) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter User Name:");
        String name = read.next();
        System.out.println("Enter password:");
        String pwd = read.next();
        UserInfoItem loginStatus = facade.login(name, pwd, users);
        if(loginStatus == null) {
            System.out.println("login failed");
            Login(facade, users);
            return null;
        }
        return loginStatus;
    }
    public static Facade Session(Facade facade, ArrayList<UserInfoItem> users) throws ParseException {
        UserInfoItem loginStatus = Login(facade, users);
        OfferingList offeringList = facade.getOfferingList();
        if(offeringList == null) {
            offeringList = new OfferingList();
        }
        facade.setUserType(loginStatus.isState());
        if(facade.getUserType() == false) {
            System.out.println("Press 1 for Meat menu");
            System.out.println("Press 2 for Produce menu");
            System.out.println("Press 3 to Logout");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if(choice.equals("1")) {
                facade.setnProductCategory(1);
            } else if(choice.equals("2")){
                facade.setnProductCategory(0);
            } else {
                Session(facade, users);
            }
            Offering offering = facade.getThePerson().showMenu(facade);
            offering.setPerson(loginStatus);
            offeringList.createNewOffering(offering);
            OfferingIterator offeringIterator = offeringList.getOfferingIterator();
            while(offeringIterator != null) {
                System.out.println("Bid for "+offeringIterator.getOffering().getProduct().getProductName()+" by "+offeringIterator.getOffering().getPerson().getUser()+" closes at "+offeringIterator.getOffering().getBidCloseDate());
                offeringIterator = offeringIterator.Next();
            }
        } else {
            System.out.println("Press 1 for checking available bids");
            System.out.println("Press 2 to Logout");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if(choice.equals("2")) {
                Session(facade, users);
            }
            offeringList = facade.getThePerson().showAddButton(facade);
        }
        facade.setOfferingList(offeringList);
        return facade;
    }
    public static void main(String[] args) {
        try {

            // Scanning buyers list for details
            File myObj = new File("BuyerInfo.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<UserInfoItem> users = new ArrayList<>();
            Facade facade = new Facade();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                users.add(new UserInfoItem(parts[0], parts[1], true));
            }
            myReader.close();

            //Scanning Sellers list for details
            myObj = new File("SellerInfo.txt");
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                users.add(new UserInfoItem(parts[0], parts[1], false));
            }
            myReader.close();

            //Scanning Product Information
            myObj = new File("ProductInfo.txt");
            myReader = new Scanner(myObj);
            ClassProductList productList = new ClassProductList(new ProductIterator());
            Product product;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                if(parts[0].equals("Meat")) {
                    product = new Product(true, parts[1]);
                } else {
                    product = new Product(false, parts[1]);
                }
                productList.createNewProduct(product);
            }
            myReader.close();
            facade.setTheProductList(productList);

            while(true) {
                facade = Session(facade, users);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
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
//            ProductIterator productIterator = facade.getTheProductList().getProductIterator();
//            System.out.println("out:"+productIterator.getProduct().getProductName());
//            System.out.println("out:"+productIterator.hasNext());
//            if(productIterator == null) {
//                productIterator = new ProductIterator();
//            }
//            while(productIterator != null) {
//                if(productIterator.getProduct().isProductType() == false) {
//                    System.out.println(productIterator.getProduct().getProductName());
//                }
//                productIterator = productIterator.Next();
//            }
            Scanner read = new Scanner(System.in);
            System.out.println("Enter User Name:");
            String name = read.next();
            System.out.println("Enter password:");
            String pwd = read.next();
            UserInfoItem loginStatus = facade.login(name, pwd, users);
            OfferingList offeringList = facade.getOfferingList();
            if(offeringList == null) {
                offeringList = new OfferingList();
            }
            if (loginStatus != null) {
                facade.setUserType(loginStatus.isState());
                System.out.println("Press 1 for Meat menu");
                System.out.println("Press 2 for Produce menu");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                ProductMenu productMenu;
                if(choice.equals("1")) {
                    facade.setnProductCategory(1);
                } else {
                    facade.setnProductCategory(0);
                }
//                facade.getThePerson().showMenu(facade);
                if(facade.getUserType()) {
                    Offering offering = facade.getThePerson().showMenu(facade);
                    offering.setPerson(loginStatus);
                    offeringList.createNewOffering(offering);
                }
//                else {
                    OfferingIterator offeringIterator = offeringList.getOfferingIterator();
                    while(offeringIterator != null) {
                        System.out.println("Bid for "+offeringIterator.getOffering().getProduct().getProductName()+" by "+offeringIterator.getOffering().getPerson().getUser()+" closes at "+offeringIterator.getOffering().getBidCloseDate());
                        offeringIterator = offeringIterator.Next();
                    }
//                }

            } else {
                System.out.println("login failed");
            }
        } catch (FileNotFoundException | ParseException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

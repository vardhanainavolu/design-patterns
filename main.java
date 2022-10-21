import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static ArrayList<UserInfoItem> users = new ArrayList<>();
    public static UserInfoItem Login(Facade facade) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter User Name:");
        String name = read.next();
        System.out.println("Enter password:");
        String pwd = read.next();
        UserInfoItem loginStatus = facade.login(name, pwd, users);
        if(loginStatus == null) {
            System.out.println("login failed");
            Login(facade);
            return null;
        }
        return loginStatus;
    }
    public static Facade Session(Facade facade) throws ParseException {
        UserInfoItem loginStatus = Login(facade);
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
                Session(facade);
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
            System.out.println("Press 2 for checking owned goods");
            System.out.println("Press 3 to Logout");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if(choice.equals("3")) {
                Session(facade);
            } else if(choice.equals("2")) {
                ArrayList<Product> products = loginStatus.getProducts();
                if(products.size() == 0) {
                    System.out.println("No goods are owned by you");
                }
                for(int i = 0; i < products.size(); ++i) {
                    System.out.println(products.get(i));
                }
            } else {
                offeringList = facade.getThePerson().showAddButton(facade);
            }
        }
        facade.setOfferingList(offeringList);
        Random rand = new Random();
        int randInt = rand.nextInt(1000);
        ReminderVisitor reminderVisitor = new ReminderVisitor();
        Object obj[] = reminderVisitor.visitFacade(facade);
        facade.setOfferingList((OfferingList)obj[0]);
        UserInfoItem tempUser = (UserInfoItem) obj[1];
        for(int i = 0; i < users.size(); ++i) {
            if(users.get(i).getUser().equals(tempUser.getUser())) {
                for(int j = 0; j < tempUser.getProducts().size(); ++j) {
                    users.get(i).addProducts(tempUser.getProducts().get(j));
                }
            }
        }
        return facade;
    }
    public static void main(String[] args) {
        try {

            // Scanning buyers list for details
            File myObj = new File("BuyerInfo.txt");
            Scanner myReader = new Scanner(myObj);
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
                facade = Session(facade);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}

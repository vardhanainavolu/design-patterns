import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            File myObj = new File("BuyerInfo.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<UserInfoItem> users = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                Facade facade = new Facade();
                users.add(new UserInfoItem(parts[0], parts[1], true));
            }
            myReader.close();
            myObj = new File("SellerInfo.txt");
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                Facade facade = new Facade();
                users.add(new UserInfoItem(parts[0], parts[1], false));
            }
            myReader.close();
            Scanner read = new Scanner(System.in);
            System.out.println("Enter User Name:");
            String name = read.next();
            System.out.println("Enter password:");
            String pwd = read.next();
            Facade facade = new Facade();
            boolean loginStatus = facade.login(name, pwd, users);
            if (loginStatus) {
                facade.getThePerson().showMenu();
            } else {
                System.out.println("login failed");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            File myObj = new File("BuyerInfo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(":");
                Facade facade = new Facade();
                UserInfoItem user = new UserInfoItem(parts[0], parts[1]);
            }
            myReader.close();
            Scanner read = new Scanner(System.in);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

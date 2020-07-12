package Library;
//Панель керування меню користувача
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserService extends Library{

    //  Exception message if incorrect data
    public void inputUser() {

        Scanner scan = new Scanner(System.in);
        try {
            menuUser(scan.nextInt());

        } catch (InputMismatchException e) {
            System.err.println(e + " - incorrect data, please try again");
            inputUser();
        }
    }

    //  menu User select items
    private void menuUser(int choice) {

        switch (choice) {
            case 1 -> {
                // admin
                AdminService ad = new AdminService();
                ad.loginAdmin();
            }
            case 2 -> {
                // look at the available books
                showAvailable();
            }
            case 3 -> {
                // look at all genres
                viewByGenre();
            }
            case 4 -> {
                // take a book
                // ...
            }
            case 5 -> {
                // delete book
                // ....
            }
            case 6 -> {
                // exit the program
                System.out.println("the program is closed");
                System.exit(0);
            }
            default -> {
                System.out.println("please select items 1-6: ");
                Scanner scan = new Scanner(System.in);
                menuUser(scan.nextInt());
            }
        }
    }
}

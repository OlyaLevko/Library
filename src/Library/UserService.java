package Library;
//Панель керування меню користувача

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserService {

    Menu menu = new Menu();
    Library library = new Library();

    //  if incorrect data, then Exception message
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
    public void menuUser(int choice) {

        switch (choice) {
            case 1 -> {
                // admin
                AdminService ad = new AdminService();
                ad.loginAdmin();
            }
            case 2 -> {
                // look at the available books
                library.showAvailable();
                menu.startApp();
            }
            case 3 -> {
                // look at all genres
                library.viewByGenre();
                menu.startApp();
            }
            case 4 -> {
                // take a book
                // ...
            }
            case 5 -> {
                // exit the program
                System.out.println("the program is closed");
                System.exit(0);
            }
            default -> {
                System.out.println("please select items 1-5: ");
                Scanner scan = new Scanner(System.in);
                menuUser(scan.nextInt());
            }
        }
    }
}

package Library;

import java.util.Scanner;

public class UserService {

    Library library = new Library();
    AdminService adminService = new AdminService();

    //  if incorrect data, then Exception message
    public void inputUser() {

        Scanner scan = new Scanner(System.in);
        try {
            menuUser(scan.nextInt());

        } catch (IncorrectLoginException e) {
            System.err.println(e.toString());
            inputUser();
        }
    }

    //  menu User select items
    public void menuUser(int choice) {

        switch (choice) {
            case 1 -> {
                // admin
                adminService.loginAdmin();
            }
            case 2 -> {
                // available books
                library.showAvailable();

            }
            case 3 -> {
                // look genres
                library.showByGenre();

            }
            case 4 -> {
                // take a book
                library.takeBook();
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

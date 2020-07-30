package Library;

import java.util.*;

public class AdminService {

    private final String ADMIN = "admin";

    Library library = new Library();
    Menu menu = new Menu();

    //  equals admin
    private boolean isAdmin(String username) {
        return ADMIN.equals(username);
    }

    //  if incorrect data, then Exception message
    public void inputAdmin() {

        Scanner scan = new Scanner(System.in);
        try {
            menuAdmin(scan.nextInt());

        } catch (IncorrectLoginException e) {
            System.err.println(e.toString());
            inputAdmin();
        }
    }

    //  menu Admin select items
    public void menuAdmin(int choice) {

        switch (choice) {
            case 1 -> {
                // add book / books
                library.addBook();

            }
            case 2 -> {
                // remove book
                library.removeBook();
            }

            case 3 -> {
                // available books
                library.showAvailable();
            }
            case 4 -> {
                // using book
                library.showInUsing();
            }
            case 5 -> {
                // debtors
                // library.showDebtors();
            }
            case 6 -> {
                // return to the main menu
                menu.startApp();
            }
            default -> {
                System.out.println("please select items 1-6: ");
                Scanner scan = new Scanner(System.in);
                menuAdmin(scan.nextInt());
            }
        }
    }

    // login admin
    public void loginAdmin() {

        System.out.println("please type login: ");
        Scanner scan = new Scanner(System.in);
        String login = scan.nextLine();
        try {
            if (login.equals(ADMIN)) {
                checkLogin(ADMIN);
            } else {
                throw new IncorrectLoginException("incorrect login, please try again:");
            }
        } catch (IncorrectLoginException e) {
            System.out.println(e.toString());
            String loginAdmin = scan.nextLine();
            String EXIT = "exit";
            if (loginAdmin.equals(ADMIN)) {
                checkLogin(ADMIN);
            } else
                System.err.println("incorrect login, please type correct login or type " + EXIT);
            String loginChoice = scan.nextLine();
            if (loginChoice.equals(EXIT)) {
                menu.startApp();
            } else if (loginChoice.equals(ADMIN)) {
                checkLogin(ADMIN);
            }
        }
        loginAdmin();
    }

    //  check for admin
    private void checkLogin(String login) {

        if (isAdmin(login)) {
            menu.startAdmin();
        }
    }
}

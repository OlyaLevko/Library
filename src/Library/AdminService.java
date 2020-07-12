package Library;

import java.util.InputMismatchException;
import java.util.Scanner;

//панель керування меню адміна
public class AdminService extends Library {
    Menu menu = new Menu();

    private boolean isAdmin(String username) {
        return "admin".equals(username);
    }

    //  if incorrect data, then Exception message
    public void inputAdmin() {

        Scanner scan = new Scanner(System.in);
        try {
            menuAdmin(scan.nextInt());

        } catch (InputMismatchException e) {
            System.err.println(e + " - incorrect data, please try again");
            inputAdmin();
        }
    }

    //  menu Admin select items
    private void menuAdmin(int choice) {

        switch (choice) {
            case 1 -> {
                // add book / books
                // ...
            }
            case 2 -> {
                // delete book
                // ...
            }
            case 3 -> {
                // look at the available books
                // ...
            }
            case 4 -> {
                // books that users have
                showInUsing();
            }
            case 5 -> {
                // look at debtors
                // ...
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

    //  login admin input
    public void loginAdmin() {

        System.out.println("please type login: ");
        Scanner scan = new Scanner(System.in);
        String strLogin = scan.nextLine();
        do {

            if (strLogin.matches("admin")) {
                checkLogin("admin");

            } else {
                System.out.println("incorrect login, please type login or 'exit': ");
                strLogin = scan.nextLine();

                if (strLogin.matches("admin")) {
                    checkLogin("admin");

                } else if (strLogin.matches("exit")) {
                    menu.startApp();
                }
            }

        } while (!strLogin.matches("admin") || !strLogin.matches("exit"));
    }

    //  check for admin
    private void checkLogin(String login) {

        if (isAdmin(login)) {
            menu.startAdmin();
        }
    }
}
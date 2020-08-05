package com.lits.library;

import java.util.*;

public class AdminService {

    private final String LOGIN_ADMIN = "admin";
    Library library;
    Scanner sc = new Scanner(System.in);

    public AdminService(Library library) {
        this.library = library;
    }

    private boolean isAdmin(String login) {
        return LOGIN_ADMIN.equals(login);
    }

    public void enterLogin() {
        System.out.println("Enter login");
        String login = sc.nextLine();
        try {
            if (isAdmin(login))
                adminMenu();
            else {
                throw new IncorrectLoginException("Incorrect login");
            }
        } catch (IncorrectLoginException e) {
            System.out.println(e.getMessage());
            System.out.println("To enter login again - enter \"yes\"");
            System.out.println("To return to previous menu - enter \"exit\"");
            String entry = sc.nextLine();
            while (!entry.matches("yes|exit")) {
                System.out.println("To enter login again - enter \"yes\"");
                System.out.println("To return to previous menu - enter \"exit\"");
                entry = sc.nextLine();
            }
            if ("yes".equals(entry))
                enterLogin();
        }
    }

    public void adminMenu() {

        System.out.println("Add book - 1");
        System.out.println("Remove book - 2");
        System.out.println("View debtors - 3");
        System.out.println("View in using - 4");
        System.out.println("View available - 5");
        String entry = sc.nextLine();
        while (!entry.matches("[1-5]")) {
            System.out.println("Please, choose the one of point 1-5");
            entry = sc.nextLine();
        }
        int choice = Integer.parseInt(entry);
        adminChoice(choice);
        System.out.println("To admin menu - 1");
        System.out.println("To previous menu - 2");
        entry = sc.nextLine();
        while (!entry.matches("[1-2]")) {
            System.out.println("Please, choose the one of point 1 or 2");
            entry = sc.nextLine();
        }
        if (Integer.parseInt(entry) == 1)
            adminMenu();
    }

    private void adminChoice(int choice) {

        switch (choice) {
            case 1 -> {
                library.addBook();
            }
            case 2 -> {
                library.removeBook();
            }
            case 3 -> {
                library.showDebtors();
            }
            case 4 -> {
                library.showInUsing();
            }
            case 5 -> {
                library.showAvailable();
            }
        }
    }
}

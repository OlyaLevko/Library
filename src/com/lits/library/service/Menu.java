package com.lits.library.service;

import com.lits.library.books.Library;

import java.util.Scanner;

public class Menu {

    private Library library = new Library();
    private UserService us = new UserService(library);
    private AdminService as = new AdminService(library);
    Scanner sc = new Scanner(System.in);

    // start program
    public void greetMenu() {
        do {
            System.out.println("View available - 1");
            System.out.println("View by genre - 2");
            System.out.println("Take a book - 3");
            System.out.println("Give a book back - 4");
            System.out.println("Admin - 5");
            System.out.println("Exit - 6");

            String entry = sc.nextLine();

            while (!entry.matches("[1-6]")) {
                System.out.println("Please, choose the one of point 1-6");
                entry = sc.nextLine();
            }
            int a = Integer.parseInt(entry);
            if (a >= 1 && a < 5) {
                us.userChoice(a);
            } else if (a == 5) {
                as.enterLogin();
            } else if (a == 6) {
                System.out.println("By");
                System.exit(0);
            }
        } while (true);
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public UserService getUs() {
        return us;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    public AdminService getAs() {
        return as;
    }

    public void setAs(AdminService as) {
        this.as = as;
    }
}
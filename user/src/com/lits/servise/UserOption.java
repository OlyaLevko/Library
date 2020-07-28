package com.lits.servise;

import com.lits.base.BaseOfUsers;
import com.lits.user.User;

import java.util.HashMap;
import java.util.Map;

public class UserOption {
    private User user;
    private BaseOfUsers baseOfUsers;

    public BaseOfUsers downloadBaseOfUsers(){
        baseOfUsers = new BaseOfUsers();
        return baseOfUsers;
    }

    public User addUser(){
        this.user = new User();
        return user;
    }

    public User addUser(String firstName, String surName){
        this.user = new User(firstName, surName);
        return user;
    }

    public String getUserFirstName() {
        return user.getFirstName();
    }

    public void setUserFirstName(String firstName) {
        if(firstName.matches("^[A-Z][\\p{L}'-]+$")) {
            user.setFirstName(firstName);
        }
        else System.out.println("You are trying to enter an incorrect First name.");
    }

    public String getUserSurname() {
        return user.getSurname();
    }

    public void setUserSurname(String surname) {
        if(surname.matches("^[A-Z][\\p{L}'-]+$")) {
            user.setSurname(surname);
        }
        else System.out.println("You are trying to enter an incorrect surname.");
    }
    
    public User getUserByLogin(String login){
        return baseOfUsers.getUser(login);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BaseOfUsers getBaseOfUsers() {
        return baseOfUsers;
    }
    public Map<String, User> getMapOfUsers(){
        return baseOfUsers.getBaseOfUsers();
    }

    public void setBaseOfUsers(BaseOfUsers baseOfUsers) {
        this.baseOfUsers = baseOfUsers;
    }
}

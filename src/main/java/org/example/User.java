package org.example;

public class User {
    //attributes
    private String username;
    private String password;
    private boolean isLoggedIn;

    //constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    //create a method for logging the user in
    public void login(String enteredPassword) {
        if (enteredPassword.equals(password)) {
            isLoggedIn = true;
            System.out.println("Login Successful. welcome, " + username + "!");
        }else{
            System.out.println("Incorrect Password. Login Failed!");
        }
    }
    //create a method for logging out the user
    public void logout() {
        isLoggedIn = false;
        System.out.println("Logout Successful. Goodbye, " + username + "!");
    }
}

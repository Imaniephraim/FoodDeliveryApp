package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //attributes
    private List<User> users;
    private User currentUser;
    private List<Delivery> deliveries;
    private List<Food> menu;

    //constructor
    public Main(){
        users = new ArrayList<>();
        //add some sample
        users.add(new User("Dennis", "password"));
        users.add(new User("Muzna", "password"));

        deliveries = new ArrayList<>();
        menu = new ArrayList<>();

        //populate our menu with some food items
        menu.add(new Food("Pizza", 899));
        menu.add(new Food("Burger", 599));
        menu.add(new Food("Sushi", 1249));
    }
    //login the user
    public  void  login(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                currentUser = user;
                currentUser.login(password);
                return;
            }
        }
        System.out.println("User Not Found, Login failed!");
    }
    //logout the user
    public void logout() {
        if (currentUser != null && currentUser.isLoggedIn()) {
            currentUser.logout();
            currentUser = null;
        }else{
            System.out.println("No user is currently logged in,");
        }
    }

    //a method for recording deliveries
    public  void  recordDelivery(String location, double cost){
        deliveries.add(new Delivery(location, cost));
        System.out.println("Delivery recorded successfully. location: " + location + ", Cost: Ksh" + cost);
    }

    //create a new method for displaying all the deliveries
    public void displayDeliveries() {
        if (deliveries.isEmpty()) {
            //no deliveries
            System.out.println("No deliveries recorded yet!");
        }else{
            //there are deliveries
            System.out.println("All Deliveries");
            for (Delivery delivery : deliveries){
                System.out.println("Location: " + delivery.getLocation() + ", Cost: Ksh" + delivery.getCost());
            }
        }
    }

    //a method to calculate the total cost
    public void calculateTotalCost() {
        double totalCost = 0;
        for (Delivery delivery : deliveries) {
            totalCost += delivery.getCost();
        }
        System.out.println("Total cost of deliveries: Ksh" + totalCost);
    }

    //a method to display a name
    public void displayMenu() {
        System.out.println("Welcome to CPL Food Delivery Menu");
        for (int i = 0; i < menu.size(); i++) {
            Food food = menu.get(i);
            System.out.println((i+1) + ", " + food.getName() + " - Ksh" + food.getPrice());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main app = new Main();
        int userChoice;
        do {
            System.out.println("\n1. login");
            System.out.println("2. Logout");
            System.out.println("3. Record delivery");
            System.out.println("4. Display Delivery");
            System.out.println("5.Calculate Total Cost");
            System.out.println("6. Display the menu");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // consumes new line character

            switch (userChoice){
                case 1:
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();

                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();

                    app.login(username, password);
                    break;
                case 2:
                    app.logout();
                    break;
                case 3:
                    if (app.currentUser != null && app.currentUser.isLoggedIn()) {
                        System.out.println("Enter Delivery Location: ");
                        String location = scanner.nextLine();

                        System.out.println("Enter Delivery Cost: ");
                        double cost = scanner.nextDouble();

                        app.recordDelivery(location, cost);
                    }else {
                        System.out.println("Please Login First!");
                    }
                    break;
                case 4:
                    app.displayDeliveries();
                    break;
                case 5:
                    app.calculateTotalCost();
                    break;
                case 6:
                    app.displayMenu();
                    break;
                case 7:
                    System.out.println("Exiting The App");
                    break;

            }
        }while (userChoice != 7);
    }
}




























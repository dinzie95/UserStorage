package com.userstorageapp;

import java.util.Scanner;

public class AppHome {

    static boolean userLogged = false;

    public static void main(String[] args) throws Exception {

        int option = 0;

        System.out.println("*********************************\n");
        System.out.println("Welcome to User Storage\n");
        System.out.println("*********************************\n");

        while (option != -1) {

        Scanner sn = new Scanner(System.in);
        option = getUserActionBeforeLogIn();

        //Login
        if (option == 1) {
            String email, pwd;
            System.out.print("Enter Email Address : ");
            email = sn.next();
            System.out.print("Enter Password : ");
            pwd = sn.next();

            userLogged = Login.userLogin(email, pwd);

            if (userLogged) {
                Login.getNewAction();

            } else {
                getUserActionBeforeLogIn();
            }


            //Register
        } else if (option == 2) {
            RegisterNewUser.addNewUser();
            getUserActionBeforeLogIn();

            //View Users
        } else if (option == 3) {

            if (userLogged == false) {
                System.out.println("Please Log in to view users!\n\n");
                getUserActionBeforeLogIn();
            } else {
                try {
                    DisplayUsers.getUsers();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    Login.getNewAction();
                }
            }

            //Invalid response
        } else {
            System.out.println("Invalid Response!\n\n");
            getUserActionBeforeLogIn();
        }

    }
        System.exit(0);
    }

    public static int getUserActionBeforeLogIn(){
        Scanner sn = new Scanner(System.in);
        int action;

        System.out.println("\n*********************************\n");
        System.out.println("You can select an option from below to proceed =>");
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("3 -> View Users");
        System.out.println("-1 -> Exit");
        System.out.println("Please enter the option number to proceed: ");

        action=sn.nextInt();
        return action;
    }

}

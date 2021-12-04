package com.userstorageapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {


    public static String currentUser;

    public static boolean userLogin(String email, String pwd){

        try{
            Connection con= DatabaseConnection.getConnection();
            PreparedStatement statement =con.prepareStatement("SELECT * from UserCredentials WHERE  email = ? AND pwd = ?");
            statement.setString(1, email);
            statement.setString(2, pwd);

            ResultSet result=statement.executeQuery();

            if(result.next()){
                AppHome.userLogged=true;
                currentUser=email;
                System.out.println("Logged successfully !");
                return true;
            }
            else {
                System.out.println("Incorrect email or password !");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }

    public static void userLogout(){
        currentUser="";
        AppHome.userLogged=false;
        System.out.println("User Logged out successfully !");
    }

    public static void getNewAction() throws Exception {
        int action;
        Scanner sn = new Scanner(System.in);
        System.out.println("\n*********************************\n");
        System.out.println("You can select an option from below to proceed =>");
        System.out.println("1. Logout");
        System.out.println("2. View Users");
        System.out.println("-1 -> Exit");
        System.out.println("Please enter the option number to proceed: ");

        action =sn.nextInt();

        //Logout the User
        if (action == 1) {
            Login.userLogout();
            AppHome.getUserActionBeforeLogIn();
            //Display Users
        } else if (action == 2) {
            DisplayUsers.getUsers();
            getNewAction();
            //Exit from system
        } else if (action == 3) {
            System.exit(0);
        }

    }
}

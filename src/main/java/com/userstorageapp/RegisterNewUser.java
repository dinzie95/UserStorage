package com.userstorageapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegisterNewUser {


    public static void addNewUser() {

        Scanner sn = new Scanner(System.in);
        System.out.print("Enter First Name and Last Name : ");
        String userName=sn.nextLine();
        System.out.print("Enter Email : ");
        String email=sn.nextLine();
        System.out.print("Enter Password (Maximum 10 characters) : ");
        String pwd=sn.nextLine();
        System.out.print("Confirm Password : ");
        String confirmPwd=sn.nextLine();


        while (!pwd.equals(confirmPwd)){
            System.out.println("Passwords don't match. Re-enter Password");
            System.out.print("Enter Password (Maximum 10 characters) : ");
            pwd=sn.nextLine();
            System.out.print("Confirm Password : ");
            confirmPwd=sn.nextLine();
        }

        try{
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO UserCredentials(user_name, email,pwd) VALUES ('"+userName+"', '"+email.toLowerCase()+"','"+pwd+"')");

            int update=statement.executeUpdate();

            if(update==1){
                System.out.println("User Registered successfully !");
                System.out.println("You can Login to your account with the credentials you provided.");
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}

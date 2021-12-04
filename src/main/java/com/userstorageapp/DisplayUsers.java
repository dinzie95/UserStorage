package com.userstorageapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayUsers {

    public static void getUsers() throws Exception{
        try{
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM UserCredentials");

            ResultSet result = statement.executeQuery();

            System.out.println("Name\t\t\t\tEmail Address");
            while(result.next()){
                System.out.print(result.getString("user_name"));
                System.out.print("\t\t\t\t");
                System.out.println(result.getString("email"));

            }

        }catch(Exception e){
            System.out.println(e);
        }


    }
}

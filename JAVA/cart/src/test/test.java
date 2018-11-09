package test;

import java.sql.*;

public class test {
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success loading Mysql Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }
}

package com.example;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/account";
        String user = "root";
        String password = "aditya@2005";
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            con.setAutoCommit(false);

            stmt.executeUpdate("update acc_data set ac_balance = ac_balance -1000 where ac_id = 1");
            System.out.println("Money Debited from account");

            stmt.executeUpdate("update acc_data set ac_balance = ac_balance + 1000 where ac_id = 2");
            System.out.println("Payment Successfully");
            con.commit();
            System.out.println("Transaction committed to database.");

        } catch (SQLException e) {
            try {
                System.out.println("Error caught! Money rolled back to user account.");
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Payment Failed");
            throw new RuntimeException(e);
        }
    }
}

package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        String URL ="jdbc:mysql://127.0.0.1:3306/student";
//        String USER = "root";
//        String PASSWORD = "aditya@2005";
//        try {
//
//          Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
//
//          PreparedStatement pr=con.prepareStatement("insert into student_data values (?,?,?)");
//            System.out.println("Enter id  : \n name :\n Domain :");
//            Scanner sc = new Scanner(System.in);
//
//
//          pr.setInt(1,sc.nextInt());
//          sc.nextLine();
//          pr.setString(2,sc.nextLine());
//          pr.setString(3,sc.nextLine());
//
//          //4th Step(Execute Query)
//           int rowsaffect = pr.executeUpdate();
//            System.out.println(rowsaffect);
//            if(rowsaffect>0){
//                System.out.println("Data inserted");
//            }
//            con.close();
//
//
//
//        } catch ( SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//
//        String URL = "jdbc:mysql://127.0.0.1:3306/student";
//        String USER = "root";
//        String PASSWORD = "aditya@2005";
//
//        try {
//            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//
//            Statement st = con.prepareStatement();
//
//            ResultSet rs = st.executeQuery("SELECT * FROM student_data");
//
//            while (rs.next()) {
//                System.out.println("ID : " + rs.getInt("id"));
//                System.out.println("Name : " + rs.getString("name"));
//                System.out.println("Domain : " + rs.getString("domain"));
//            }
//
//            rs.close();
//            st.close();
//            con.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}



public class Main {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://127.0.0.1:3306/student";
        String USER = "root";
        String PASSWORD = "aditya@2005";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement prt = con.prepareStatement("SELECT * FROM student_data where id =?");
            prt.setInt(1    ,2);
            ResultSet rst=prt.executeQuery();
            while(rst.next()){
                System.out.println("ID : " + rst.getInt("id"));
                System.out.println("Name : " + rst.getString("name"));
                System.out.println("Domain : " + rst.getString("domain"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
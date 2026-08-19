package dao;


import entity.Student;

import java.sql.*;

public class StudentService {
    private static Connection con=null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb1","root","aditya@2005");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public int register(Student student){
        String sql="insert into student values(?,?,?,?,?)";

        try {
            PreparedStatement prt = con.prepareStatement(sql);
            prt.setInt(1,student.getId());
            prt.setString(2, student.getName());
            prt.setString(3, student.getEmail());
            prt.setString(4,student.getRegd());
            prt.setInt(5,student.getPassword());
            return prt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int login(String email,int password){
        int result=0;
        try {
            PreparedStatement prt=con.prepareStatement("select * from student where email=? and password=?");
            prt.setString(1,email);
            prt.setInt(2,password);
            ResultSet rs=prt.executeQuery();
            if(rs.next()){
                result=1;
            }else{
                System.out.println("login failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

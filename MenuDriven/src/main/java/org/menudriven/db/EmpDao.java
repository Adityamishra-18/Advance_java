package org.menudriven.db;

import com.mysql.cj.protocol.Resultset;
import org.menudriven.Entity.Emp;

import java.sql.*;

public class EmpDao {
    String url="jdbc:mysql://127.0.0.1:3306/employee";
    String user="root";
    String password="aditya@2005";

    private static Connection con=null;
    public void connectTodb(){
        try {
            con=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int register(Emp emp){
        try {
            PreparedStatement pst=con.prepareStatement("insert into emp_data values(?,?,?,?)");
            pst.setInt(1,emp.getId());
            pst.setString(2,emp.getName());
            pst.setString(3, emp.getDepartment());
            pst.setDouble(4,emp.getSalary());
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void getNameByid(int id){
        try {
            PreparedStatement pst=con.prepareStatement("select * from emp_data where id=?");
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString(2));
            }else{
                System.out.println("Data not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAll(){
        String sql="select * from emp_data";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int update(Emp emp){
        try {
            PreparedStatement pst=con.prepareStatement("update emp_data set name=?,department=?,salary=? where id=?");
            pst.setString(1,emp.getName());
            pst.setString(2,emp.getDepartment());
            pst.setDouble(3,emp.getSalary());
            pst.setInt(4,emp.getId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int delete(int id){
        try {
            PreparedStatement pst=con.prepareStatement("delete from emp_data where id=?");
            pst.setInt(1,id);
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

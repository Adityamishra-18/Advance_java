package controller;


import dao.StudentService;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String uname =req.getParameter("username");
        String email=req.getParameter("email");
        String regd= req.getParameter("regd");
        int password= Integer.parseInt(req.getParameter("password"));
        System.out.println(id+" "+uname+" "+email+" "+" "+regd+" "+password);
        Student s1=new Student();
        s1.setId(id);
        s1.setName(uname);
        s1.setEmail(email);
        s1.setRegd(regd);
        s1.setPassword(password);

        StudentService service=new StudentService();
        int result= service.register(s1);
        System.out.println(result);

        if(result>0){
            resp.sendRedirect("login.html");
        }else{
            resp.getWriter().println("Registration failed");
        }
    }
}

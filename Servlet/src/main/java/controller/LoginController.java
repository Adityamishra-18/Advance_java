package controller;

import dao.StudentService;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        int password= Integer.parseInt(req.getParameter("password"));
        email=email.toLowerCase();
        StudentService service=new StudentService();
//        Cookie cookie=new Cookie("email",email);
//        resp.addCookie(cookie);
        Student st=service.validate(email,password);

        if(st!=null){
            System.out.println(st);
            resp.sendRedirect("home.html");
        }else{
            resp.getWriter().println("login failed");
        }
    }
}

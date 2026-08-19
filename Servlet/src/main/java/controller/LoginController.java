package controller;

import dao.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        int password= Integer.parseInt(req.getParameter("password"));
        StudentService service=new StudentService();
        int result=service.login(email,password);

        if(result>0){
            resp.sendRedirect("home.html");
        }else{
            resp.getWriter().println("login failed");
        }
    }
}

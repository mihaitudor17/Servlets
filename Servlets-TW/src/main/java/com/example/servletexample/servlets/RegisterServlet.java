package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.runTimeRepository.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register/*")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO GET REGISTER");
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String temp=request.getParameter("employed");
        Boolean employed;
        if(temp!=null)
        {
            employed=true;
        }
        else
        {
            employed=false;
        }
        System.out.println("REGISTER " + email + " + "+employed);
        User user = new User(email,employed);
        HttpSession session = request.getSession();
        Users.INSTANCE.addUser(user);
        session.setAttribute("currentUser", user);
        request.setAttribute("token",user.getToken());
        request.setAttribute("sum",0);
        getServletContext().getRequestDispatcher("/login").forward(request, response);
    }
}

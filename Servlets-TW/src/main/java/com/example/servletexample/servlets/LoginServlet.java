package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.runTimeRepository.Users;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "IndexServlet", urlPatterns = {"/","/login/*"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Check if user is already connected, if not show login page */
        System.out.println("GET   LOGIN");
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        System.out.println("USER " + currentUser);

        System.out.println("ALL USERS");
        Users.INSTANCE.getUsers().forEach(System.out::println);
        /* If not logged */
        if(Objects.isNull(currentUser)) {
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/homeServlet").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Check has the right credentials and use HomeServlet */
        Users.INSTANCE.getUsers().forEach(System.out::println);

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        String email = request.getParameter("email");
        String token;
        if(request.getParameter("token")!=null )
        {
            token= request.getParameter("token");
        }
        else
        {
            token= currentUser.getToken();
        }
        Integer sum;
        if(request.getParameter("sum")!=null) {
             sum = Integer.valueOf(request.getParameter("sum"));
        }
        else
        {
            sum=0;
            request.setAttribute("sum",0);
        }
        Integer money=new Integer(sum);
        User userByEmailAndToken = Users.INSTANCE.findUserByEmailAndToken(email,token);
        if (userByEmailAndToken!=null)
        {
            currentUser=userByEmailAndToken;
            if(sum>=100)
            {
                Users.INSTANCE.addUserPoints(currentUser.getToken());
            }
            if(sum>=500) {
                switch (currentUser.getLevel()) {
                    case 1: {
                        sum -= 5;
                        break;
                    }
                    case 2: {
                        sum -= 10;
                        break;
                    }
                    case 3: {
                        sum-=  15;
                        break;
                    }
                    case 4: {
                        sum-= 20;
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            Integer level= currentUser.getLevel();
            Integer points= currentUser.getPoints();
            String employed;
            if(currentUser.getEmployed())
            {
                employed="hidden";
            }
            else {
                employed="visible";
            }
            List<String> presents=currentUser.getPresents();
            request.setAttribute("token",token);
            request.setAttribute("sum",money);
            request.setAttribute("spent",sum);
            request.setAttribute("level",level);
            request.setAttribute("points",points);
            request.setAttribute("presents",presents);
            request.setAttribute("employed",employed);
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        }
        else {
            /* Otherwise, reload the form  */
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
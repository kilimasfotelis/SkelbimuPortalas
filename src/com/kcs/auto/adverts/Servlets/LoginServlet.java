package com.kcs.auto.adverts.Servlets;

import com.kcs.auto.adverts.service.LoginService;
import com.kcs.auto.adverts.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 2017-03-10.
 */
@WebServlet(value="/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim(); //trim nuima tarpus
        String password = req.getParameter("password").trim();
        String page = "advertsResult.jsp";
        LoginService loginService = new LoginServiceImpl();
       boolean isHaveAccess = loginService.isUserHavePermissions(email, password);
        if (isHaveAccess == false){
            req.setAttribute("error", "blogi duomenai");
        }
        req.getRequestDispatcher("advertResult.jsp").forward(req, resp);

    }
   /* private boolean isStringNotBlank(String value){
        boolean val = false;
        if (value!=null && !value.equals("") && value.length() > 3){
            val=true;
        }
        return val;
    }*/
}

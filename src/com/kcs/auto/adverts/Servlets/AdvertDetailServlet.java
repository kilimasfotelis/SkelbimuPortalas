package com.kcs.auto.adverts.Servlets;

import com.kcs.auto.adverts.service.AdvertsService;
import com.kcs.auto.adverts.service.impl.AdversServiceImpl;
import com.kcs.auto.adverts.vo.Advert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 2017-03-10.
 */
@WebServlet(value = "/advertDetail")
public class AdvertDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String advertId = req.getParameter("id");
        AdvertsService advertsService = new AdversServiceImpl();
        Advert advert = advertsService.getAdvertById(Integer.valueOf(advertId));
        req.setAttribute("advert", advert);
        req.getRequestDispatcher("advertDetail.jsp").forward(req,resp);
    }
}

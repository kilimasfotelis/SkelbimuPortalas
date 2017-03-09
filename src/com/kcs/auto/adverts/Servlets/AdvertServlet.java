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
import java.util.List;

/**
 * Created by User on 2017-03-09.
 */
@WebServlet(value = "/adverts")
public class AdvertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertsService advertsService = new AdversServiceImpl();
        List<Advert> adverts = advertsService.getAdverts();
        req.setAttribute("adverts", adverts);
        req.getRequestDispatcher("advertsResult.jsp").forward(req, resp);
    }
}

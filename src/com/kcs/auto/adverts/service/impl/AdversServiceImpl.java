package com.kcs.auto.adverts.service.impl;

import com.kcs.auto.adverts.service.AdvertsService;
import com.kcs.auto.adverts.service.ConnectionService;
import com.kcs.auto.adverts.vo.Advert;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017-03-09.
 */
public class AdversServiceImpl implements AdvertsService {

    @Override
    public List<Advert> getAdverts() {
        List<Advert> adverts = new ArrayList<>();
        ConnectionService connectionService = new ConnectionServiceImpl();
        Connection connection = connectionService.createConnection();
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM adverts");
                while(resultSet.next()){
                    Advert advert = getAdvertFromResultSet(resultSet);
                            if (advert!=null){
                                adverts.add(advert);
                            }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adverts;
    }

    @Override
    public Advert getAdvertById(int advertId) {
        ConnectionService connectionService = new ConnectionServiceImpl();
        Connection connection = connectionService.createConnection();
        Advert advert = new Advert();
        if (connection != null){
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM adverts where id=?");
                statement.setInt(1, advertId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    advert = getAdvertFromResultSet(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return advert;
    }
    private Advert getAdvertFromResultSet(ResultSet resultSet){
        Advert advert = null;
        try {
            advert = new Advert(resultSet.getInt("ID"),
            resultSet.getBigDecimal("PRICE"),
            resultSet.getString("DESCRIPTION"),
            resultSet.getDate("INSERT_TIME"),
            resultSet.getString("CITY"),
            resultSet.getDate("ACTIVE_TIME"),
            resultSet.getString("EMAIL"),
            resultSet.getString("PHONE"),
            resultSet.getString("SHORT_DESCRIPTION"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advert;
    }

}

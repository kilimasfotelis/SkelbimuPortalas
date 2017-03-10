package com.kcs.auto.adverts.service.impl;

import com.kcs.auto.adverts.service.ConnectionService;
import com.kcs.auto.adverts.service.LoginService;
import com.kcs.auto.adverts.utils.SecurityUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 2017-03-10.
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isUserHavePermissions(String email, String password) {
        boolean isHaveAccess = false;
        String hashsetPassword = SecurityUtils.getHashSetPassword(password);
        ConnectionService connectionService = new ConnectionServiceImpl();
        Connection connection = connectionService.createConnection();
        if (connection!=null){
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * from login where USEREMAIL=? and EMAILPASSWORD=?");
                statement.setString(1, email);
                statement.setString(2, hashsetPassword);
                ResultSet resultSet = statement.executeQuery();
                isHaveAccess = resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isHaveAccess;
    }
}

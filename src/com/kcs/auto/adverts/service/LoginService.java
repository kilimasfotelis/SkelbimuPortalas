package com.kcs.auto.adverts.service;

/**
 * Created by User on 2017-03-10.
 */
public interface LoginService {

    boolean isUserHavePermissions(String email, String password);
}

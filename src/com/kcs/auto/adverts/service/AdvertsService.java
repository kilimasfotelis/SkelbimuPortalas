package com.kcs.auto.adverts.service;

import com.kcs.auto.adverts.vo.Advert;

import java.util.List;

/**
 * Created by User on 2017-03-09.
 */
public interface AdvertsService {
    List<Advert> getAdverts();
    Advert getAdvertById(int advertId);
}

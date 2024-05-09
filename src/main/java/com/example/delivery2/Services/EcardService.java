package com.example.delivery2.Services;

import com.example.delivery2.models.Client;
import com.example.delivery2.models.Ecard;
import com.example.delivery2.models.Goods;

import java.util.List;
import java.util.Optional;

public interface EcardService {

    Ecard addCard(Ecard ecard);
    Ecard addMoney(int money, Long id);
    Ecard minusMoney(List<Goods> goodsList, Long id);
    void deleteCard(Long id);
    Ecard findById(Long id);
    Optional<Ecard> findByClient(Client client);
    void save(Ecard ecard);



}

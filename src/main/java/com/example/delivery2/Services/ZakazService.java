package com.example.delivery2.Services;

import com.example.delivery2.Enums.Payment;
import com.example.delivery2.Enums.ZakazStatus;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Goods;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;

import java.util.List;

public interface ZakazService {
    List<Zakaz> findAll();
    List<Zakaz>findByClientAndZakazStatusNotLikeAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus,ZakazStatus zakazStatus1);

    List<Zakaz>findByGoods(Goods goods);
    Zakaz findById(Long id) throws Exception;
    Zakaz save(Zakaz zakaz);
    List<Zakaz>findByClient(Client client);
    List<Zakaz>findByZakazStatus(ZakazStatus zakazStatus);
    List<Zakaz>findByZakazStatusAndDeliver(ZakazStatus zakazStatus, Client deliver);
    Double countSalary(Long deliver_id);
    List<Zakaz>findByDeliver(Client deliver);

    void setZakazGood(List<ZakazGood> zakazGoodList, String address, Payment payment, Long deliver_id);


    long countByDeliver(Client deliver);
    List<Zakaz>findByClientAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus);



}

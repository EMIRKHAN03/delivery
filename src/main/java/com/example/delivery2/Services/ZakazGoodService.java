package com.example.delivery2.Services;

import com.example.delivery2.models.Goods;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;

import java.util.List;

public interface ZakazGoodService {
    List<ZakazGood>findByGoods(Goods goods);
    void save(ZakazGood zakazGood);
    void clear();
    long countByGoodsAndZakaz(Goods goods, Zakaz zakaz);

}

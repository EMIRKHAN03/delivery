package com.example.delivery2.repositories;

import com.example.delivery2.models.Goods;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZakazGoodsRepository extends JpaRepository<ZakazGood, Long> {
    List<ZakazGood> findByGoods(Goods goods);
    List<ZakazGood> findByZakaz(Zakaz zakaz);
    long countByGoodsAndZakaz(Goods goods, Zakaz zakaz);
}

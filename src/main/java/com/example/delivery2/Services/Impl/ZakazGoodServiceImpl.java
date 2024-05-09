package com.example.delivery2.Services.Impl;

import com.example.delivery2.Services.ZakazGoodService;
import com.example.delivery2.models.Goods;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;
import com.example.delivery2.repositories.ZakazGoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ZakazGoodServiceImpl implements ZakazGoodService {
    ZakazGoodsRepository zakazGoodsRepository;
    @Override
    public List<ZakazGood> findByGoods(Goods goods) {
        return zakazGoodsRepository.findByGoods(goods);
    }

    @Override
    public void save(ZakazGood zakazGood) {
        zakazGoodsRepository.save(zakazGood);

    }
    public List<ZakazGood>findByZakaz(Zakaz zakaz){
        return zakazGoodsRepository.findByZakaz(zakaz);
    }

    @Override
    public void clear() {
        zakazGoodsRepository.deleteAll();

    }

    @Override
    public long countByGoodsAndZakaz(Goods goods, Zakaz zakaz) {
        return zakazGoodsRepository.countByGoodsAndZakaz(goods, zakaz);
    }
}

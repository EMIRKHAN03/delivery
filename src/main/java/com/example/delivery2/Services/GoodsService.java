package com.example.delivery2.Services;

import com.example.delivery2.models.Distributor;
import com.example.delivery2.models.Goods;

import java.util.List;

public interface GoodsService {
    Goods findById(Long id);
    List<Goods> findByDistributor(Distributor distributor);
    Goods save(Goods goods);
    List<Goods> findAll();
    List<Goods>searchByNameLikeAndDistributor(String name, Distributor distributor);
    List<Goods>searchByNameLike(String a);




}

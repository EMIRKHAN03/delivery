package com.example.delivery2.Services.Impl;

import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.GoodsService;
import com.example.delivery2.models.Distributor;
import com.example.delivery2.models.Goods;
import com.example.delivery2.repositories.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {
    GoodsRepository goodsRepository;


    @Override
    public Goods findById(Long id) {
        Optional<Goods> optional = goodsRepository.findById(id);
        if(optional.isEmpty()){
            throw new MainException("Wrong!");
        }
        return optional.get() ;
    }


    @Override
    public List<Goods> findByDistributor(Distributor distributor) {
        return goodsRepository.findByDistributor(distributor);
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> searchByNameLikeAndDistributor(String name, Distributor distributor) {
        return goodsRepository.searchByNameLikeAndDistributor(name, distributor);
    }

    @Override
    public List<Goods> searchByNameLike(String a) {
        return goodsRepository.searchByNameLike(a+"%");
    }


}

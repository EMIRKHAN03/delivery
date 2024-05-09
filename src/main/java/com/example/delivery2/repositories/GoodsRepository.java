package com.example.delivery2.repositories;

import com.example.delivery2.models.Distributor;
import com.example.delivery2.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long> {

    List<Goods>findByDistributor(Distributor distributor);
    List<Goods>searchByNameLike(String a);
    List<Goods>searchByNameLikeAndDistributor(String name, Distributor distributor);


}

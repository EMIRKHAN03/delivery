package com.example.delivery2.repositories;

import com.example.delivery2.Enums.ZakazStatus;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Zakaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZakazRepository extends JpaRepository<Zakaz, Long> {
    List<Zakaz>findByClient(Client client);
    List<Zakaz>findByZakazStatus(ZakazStatus zakazStatus);
    List<Zakaz>findByClientAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus);
    List<Zakaz>findByClientAndZakazStatusNotLikeAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus,ZakazStatus zakazStatus1);

    List<Zakaz>findByZakazStatusAndDeliver(ZakazStatus zakazStatus, Client deliver);

    List<Zakaz>findByDeliver(Client deliver);
    long countByDeliver(Client deliver);
    @Query(nativeQuery = true, value = "SELECT SUM(delivery_price) FROM zakaz WHERE deliver_id =?1 ")
    Double countSalary(Long deliver_id);


}

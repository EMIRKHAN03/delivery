package com.example.delivery2.Services.Impl;

import com.example.delivery2.Enums.Payment;
import com.example.delivery2.Enums.ZakazStatus;
import com.example.delivery2.Services.ZakazService;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Goods;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;
import com.example.delivery2.repositories.ZakazRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class ZakazServiceImpl implements ZakazService {
    ZakazRepository zakazRepository;
    ClientServiceImpl clientService;
    DistributorServiceImpl distributorService;
    ZakazGoodServiceImpl zakazGoodService;
    @Override
    public List<Zakaz> findAll() {
        return zakazRepository.findAll();
    }


    @Override
    public List<Zakaz> findByClientAndZakazStatusNotLikeAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus, ZakazStatus zakazStatus1) {
        return zakazRepository.findByClientAndZakazStatusNotLikeAndZakazStatusNotLike(client,ZakazStatus.Declined, ZakazStatus.Delivered);
    }

    @Override
    public List<Zakaz> findByGoods(Goods goods) {
        return null;
    }

    @Override
    public Zakaz findById(Long id) throws Exception {
        Optional<Zakaz> optionalZakaz = zakazRepository.findById(id);
        if(optionalZakaz.isEmpty()){
            throw new Exception("No such zakaz");
        }
        return optionalZakaz.get();
    }

    @Override
    public Zakaz save(Zakaz zakaz) {
        return zakazRepository.save(zakaz);
    }

    @Override
    public List<Zakaz> findByClient(Client client) {
        return zakazRepository.findByClient(client);
    }

    @Override
    public List<Zakaz> findByZakazStatus(ZakazStatus zakazStatus) {
        return zakazRepository.findByZakazStatus(zakazStatus);
    }

    @Override
    public List<Zakaz> findByZakazStatusAndDeliver(ZakazStatus zakazStatus, Client deliver) {
        return zakazRepository.findByZakazStatusAndDeliver(zakazStatus,deliver);
    }

    @Override
    public Double countSalary(Long deliver_id) {
        if(zakazRepository.countSalary(deliver_id) == null){
            return (double) 0;
        }
        return zakazRepository.countSalary(deliver_id) * 0.4;
    }

    @Override
    public List<Zakaz> findByDeliver(Client deliver) {
        return zakazRepository.findByDeliver(deliver);
    }

    @Override
    public void setZakazGood(List<ZakazGood> zakazGoods, String address, Payment payment, Long deliver_id) {
        AtomicInteger total = new AtomicInteger();
        zakazGoods.forEach(zakazGood -> {
            total.addAndGet(zakazGood.getGoods().getPrice());
        });
        Zakaz zakaz = new Zakaz();
        zakaz.setAddress(address);
        System.out.println(zakaz);
        zakaz.setPayment(payment);
        zakaz.setDistributor(distributorService.findById(deliver_id));
        zakaz.setTotalPrice(total.get() + 65);
        zakaz.setClient(clientService.currentUser().get());
        zakaz.setQuantity(zakazGoods.size());
        zakaz.setDeliveryPrice(65);
        zakaz.setZakazStatus(ZakazStatus.Received);
        zakazRepository.save(zakaz);
        System.out.println(zakaz);
        zakazGoods.forEach(zakazGood -> {
            zakazGood.setZakaz(zakaz);
        });
        for (ZakazGood z : zakazGoods
        ) {
            zakazGoodService.save(z);
        }
        System.out.println(zakaz);
    }

    @Override
    public long countByDeliver(Client deliver) {
        return  zakazRepository.countByDeliver(deliver);
    }

    @Override
    public List<Zakaz> findByClientAndZakazStatusNotLike(Client client, ZakazStatus zakazStatus) {
        return zakazRepository.findByClientAndZakazStatusNotLike(client,zakazStatus);
    }
}

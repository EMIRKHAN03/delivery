package com.example.delivery2.Services.Impl;

import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.EcardService;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Ecard;
import com.example.delivery2.models.Goods;
import com.example.delivery2.repositories.EcardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class EcardServiceImpl implements EcardService{
    EcardRepository ecardRepository;

    @Override
    public Ecard addCard(Ecard ecard) {
        return ecardRepository.save(ecard);
    }

    @Override
    public Ecard addMoney(int money, Long id) {
        Ecard ecard = findById(id);
        ecard.setBalance(ecard.getBalance()+money);
        return addCard(ecard);
    }

    @Override
    public Ecard minusMoney(List<Goods> goodsList, Long id) {
        Ecard ecard =  findById(id);
       AtomicInteger total = new AtomicInteger();
       goodsList.forEach(goods -> total.addAndGet(goods.getPrice()));
       ecard.setBalance(ecard.getBalance()-total.get());
       return addCard(ecard);
    }

    @Override
    public void deleteCard(Long id) {
         ecardRepository.deleteById(id);
    }

    @Override
    public Ecard findById(Long id) {
        Optional<Ecard> optionalEcard = ecardRepository.findById(id);
        if(optionalEcard.isEmpty()){
            throw new MainException("");
        }
        return optionalEcard.get();
    }

    @Override
    public Optional<Ecard> findByClient(Client client) {
        Optional<Ecard> optionalEcard = ecardRepository.findByClient(client);
        return optionalEcard;
    }

    @Override
    public void save(Ecard ecard) {
        ecardRepository.save(ecard);

    }


}

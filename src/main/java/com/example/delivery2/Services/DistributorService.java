package com.example.delivery2.Services;

import com.example.delivery2.models.Distributor;

import java.util.List;

public interface DistributorService {
    Distributor findById(Long id);
    Distributor save(Distributor distributor);
    List<Distributor>findAll();


}

package com.example.delivery2.Services.Impl;

import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.DistributorService;
import com.example.delivery2.models.Distributor;
import com.example.delivery2.repositories.DistributorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DistributorServiceImpl implements DistributorService {
    DistributorRepository distributorRepository;
    @Override
    public Distributor findById(Long id) {
        Optional<Distributor>optionalDistributor =  distributorRepository.findById(id);
        if(optionalDistributor.isEmpty()){
            throw new MainException("No distributor!");
        }
        return optionalDistributor.get();
    }

    @Override
    public Distributor save(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    @Override
    public List<Distributor> findAll() {
        return distributorRepository.findAll();
    }

}

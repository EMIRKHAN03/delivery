package com.example.delivery2.Services.Impl;

import com.example.delivery2.Enums.RequestStatus;
import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.RequestService;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Request;
import com.example.delivery2.repositories.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {
    RequestRepository requestRepository;

    @Override
    public Request findById(Long id) {
        Optional<Request> optionalRequest =  requestRepository.findById(id);
        if(optionalRequest.isEmpty()){
            throw new MainException("No such request");
        }
        return optionalRequest.get();
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> findByClient(Client client) {
        return requestRepository.findByClient(client);
    }

    @Override
    public void save(Request request) {
        requestRepository.save(request);
    }

    @Override
    public Optional<Request> findRequest(Long client_id) {
        return requestRepository.findRequest(client_id);
    }

    @Override
    public List<Request> findDistinctByClientAndRequestStatus(Client client, RequestStatus requestStatus) {
        return requestRepository.findDistinctByClientAndRequestStatus(client,requestStatus);
    }

    @Override
    public List<Request> findByRequestStatus(RequestStatus requestStatus) {
        return requestRepository.findByRequestStatus(RequestStatus.Considered);
    }
}

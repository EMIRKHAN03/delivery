package com.example.delivery2.Services;

import com.example.delivery2.Enums.RequestStatus;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request findById(Long id);
    List<Request>findAll();
    List<Request>findByClient(Client client);
    void save(Request request);
    Optional<Request> findRequest(Long client_id);
    List<Request>findDistinctByClientAndRequestStatus(Client client, RequestStatus requestStatus);

    List<Request>findByRequestStatus(RequestStatus requestStatus);

}

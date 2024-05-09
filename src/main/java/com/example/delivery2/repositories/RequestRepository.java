package com.example.delivery2.repositories;

import com.example.delivery2.Enums.RequestStatus;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByClient(Client client);
    @Query(nativeQuery = true, value = "select * from request where client_id =?1 order by local_time limit 1")
    Optional<Request> findRequest(Long client_id);

    List<Request>findDistinctByClientAndRequestStatus(Client client, RequestStatus requestStatus);
    List<Request>findByRequestStatus(RequestStatus requestStatus);


}

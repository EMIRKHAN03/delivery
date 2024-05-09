package com.example.delivery2.models;

import com.example.delivery2.Enums.RequestStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @Enumerated(EnumType.STRING)
    RequestStatus requestStatus;
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();


}

package com.example.delivery2.models;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ecard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    Long inn;
    int balance;
    LocalDate localDate;
    String bankName;
    int csv = (int) (Math.random() * 999);
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    public Ecard(Long inn,  LocalDate localDate, String bankName) {
        this.inn = inn;
        this.localDate = localDate;
        this.bankName = bankName;
    }

}

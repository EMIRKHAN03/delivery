package com.example.delivery2.models;

import javax.persistence.*;

import com.example.delivery2.Enums.Payment;
import com.example.delivery2.Enums.ZakazStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Zakaz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int totalPrice;
    int deliveryPrice;
    int quantity;
    @Enumerated(EnumType.STRING)
    ZakazStatus zakazStatus;
    LocalDate date = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne
    @JoinColumn(name = "deliver_id")
    Client deliver;
   @ManyToOne
   @JoinColumn(name = "zakazGood_id")
   ZakazGood zakazGood;
   @ManyToOne
   @JoinColumn(name = "distributor_id")
    Distributor distributor;
    String address;
    @Enumerated(EnumType.STRING)
    Payment payment;

    @Override
    public String toString() {
        return "Zakaz{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", quantity=" + quantity +
                ", zakazStatus=" + zakazStatus +
                ", date=" + date +
                '}';
    }
}

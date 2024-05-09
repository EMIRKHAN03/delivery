package com.example.delivery2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZakazGood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "goods_id")
    Goods goods;
    int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zakaz_id")
    Zakaz zakaz;
}

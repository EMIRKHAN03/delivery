package com.example.delivery2.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Setter
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    Distributor distributor;
    String name;
    @Column(columnDefinition = "text")
    String description;
    int price;
    String photo;
    public Goods( String description, int price) {
        this.description = description;
        this.price = price;
    }

}

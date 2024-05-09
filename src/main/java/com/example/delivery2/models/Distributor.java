package com.example.delivery2.models;

import javax.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String address;
    @Column(columnDefinition = "TEXT")
    String description;
    int quantity;
    String photo;

    public Distributor(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }
    @ElementCollection(targetClass = Integer.class)
    @Column(name = "point")
    List<Integer> point = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }
}

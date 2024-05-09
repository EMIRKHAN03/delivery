package com.example.delivery2.models;

import com.example.delivery2.Enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String photo;
    private String number;

    public Client(String username,  String name,String number) {
        this.username = username;
        this.name = name;
        this.number = number;
    }
}
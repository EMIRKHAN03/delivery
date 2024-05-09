package com.example.delivery2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    private String username;
    private String number;
    private String password;
    private String name;

}

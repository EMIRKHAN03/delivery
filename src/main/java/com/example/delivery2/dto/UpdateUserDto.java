package com.example.delivery2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class UpdateUserDto {
    String name;
    String username;
    String number;


}

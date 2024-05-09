package com.example.delivery2.dto;

import com.example.delivery2.Enums.Bank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EcardDto {
    Long inn;
    String localDate;
    Bank bank;

}

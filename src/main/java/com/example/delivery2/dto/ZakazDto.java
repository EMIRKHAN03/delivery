package com.example.delivery2.dto;

import com.example.delivery2.Enums.Payment;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@ToString
@Data
public class ZakazDto {
    Payment payment;
    String address;
}

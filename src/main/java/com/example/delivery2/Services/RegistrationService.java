package com.example.delivery2.Services;

import com.example.delivery2.dto.AuthDto;
import com.example.delivery2.dto.UserDto;
import com.example.delivery2.models.Client;

import java.util.Optional;

public interface RegistrationService {
    Optional<Client> login(AuthDto authDto);
    void registration(UserDto userDto);
    void save(Client client);
    void createAdmin(Client client);

    Client toEntity(UserDto userDto);
    UserDto toDto(Client client);


}

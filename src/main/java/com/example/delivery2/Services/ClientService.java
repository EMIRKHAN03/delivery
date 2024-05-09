package com.example.delivery2.Services;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.dto.UpdateUserDto;
import com.example.delivery2.dto.UserDto;
import com.example.delivery2.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client findById(Long id);
    Client save(Client client);
    List<Client> findAll();
    Client toEntity(UserDto userDto);
    UserDto toDto(Client client);
    Optional<Client> currentUser();
    void edit(UpdateUserDto userDto, Client client);
    UpdateUserDto toUpdateDto(Client client);
    List<Client> findByRoles(Roles roles);
    Double countByRoles(Roles roles);



}

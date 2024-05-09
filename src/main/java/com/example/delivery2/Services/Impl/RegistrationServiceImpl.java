package com.example.delivery2.Services.Impl;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.RegistrationService;
import com.example.delivery2.dto.AuthDto;
import com.example.delivery2.dto.UserDto;
import com.example.delivery2.models.Client;
import com.example.delivery2.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    ClientRepository clientRepository;
    ModelMapper modelMapper ;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<Client> login(AuthDto authDto) {
        return clientRepository.findByUsername(authDto.getUserName());
    }

    @Override
    public void registration(UserDto userDto) {
        passwordEncoder.encode(userDto.getPassword());
        clientRepository.save(toEntity(userDto));
    }
    @Override
    public void save(Client client){
        if(clientRepository.findByUsername(client.getUsername()).isPresent()){
            throw new MainException("There is already person by this username");
        }
        client.setRoles(Roles.ROLE_USER);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);

    }
    @Override
    public void createAdmin(Client client){
        if(clientRepository.findByUsername(client.getUsername()).isPresent()){
            throw new MainException("There is already person by this username");
        }
        client.setRoles(Roles.ROLE_ADMIN);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);

    }


    @Override
    public Client toEntity(UserDto userDto) {
        return modelMapper.map(userDto, Client.class);
    }

    @Override
    public UserDto toDto(Client client) {
        return modelMapper.map(client, UserDto.class);
    }
}
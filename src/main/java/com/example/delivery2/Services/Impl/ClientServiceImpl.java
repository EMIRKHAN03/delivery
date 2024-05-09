package com.example.delivery2.Services.Impl;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.Exceptions.MainException;
import com.example.delivery2.Services.ClientService;
import com.example.delivery2.dto.UpdateUserDto;
import com.example.delivery2.dto.UserDto;
import com.example.delivery2.models.Client;
import com.example.delivery2.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;
    ModelMapper modelMapper;
    @Override
    public Client findById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new MainException("No user by this id");
        }
        return optionalClient.get();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client toEntity(UserDto userDto) {
        return modelMapper.map(userDto, Client.class);
    }

    @Override
    public UserDto toDto(Client client) {
        return modelMapper.map(client, UserDto.class);
    }

    @Override
    public Optional<Client> currentUser() {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal() ;
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();

            } else {
                username = principal.toString();
            }

        return clientRepository.findByUsername(username);

    }

    @Override
    public void edit(UpdateUserDto userDto, Client client) {
        if (!userDto.getName().isEmpty() && userDto.getName().length() >= 2) {
            client.setName(userDto.getName());
        }
        if (!userDto.getUsername().isEmpty() && userDto.getUsername().length() >= 2) {
            client.setUsername(userDto.getUsername());
        }

        if (!userDto.getNumber().isEmpty() && userDto.getNumber().length() >= 2) {
            client.setNumber(userDto.getNumber());
        }

        clientRepository.save(client);
    }

    @Override
    public UpdateUserDto toUpdateDto(Client client) {
        return modelMapper.map(client, UpdateUserDto.class);
    }

    @Override
    public List<Client> findByRoles(Roles roles) {
        return clientRepository.findByRoles(roles);
    }

    @Override
    public Double countByRoles(Roles roles) {
        return clientRepository.countByRoles(roles);
    }


}

package com.example.delivery2.Controllers;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.Services.Impl.RegistrationServiceImpl;
import com.example.delivery2.dto.UpdateUserDto;
import com.example.delivery2.dto.UserDto;
import com.example.delivery2.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    RegistrationServiceImpl registrationService;
    PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/signUp")
   public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String name,@RequestParam String number){
       Client client = new Client();
       client.setUsername(username);
       client.setName(name);
       client.setNumber(number);
       client.setPassword(password);
        registrationService.save(client);
        return "redirect:/auth/login";
    }




}

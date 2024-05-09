package com.example.delivery2.Controllers;

import com.example.delivery2.models.Client;
import com.example.delivery2.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
//@RequestMapping("/admin")
public class HelloController {
    ClientRepository clientRepository;

//    @GetMapping("/hello")
//    public String hello(Model model, @ModelAttribute Client client){
//        List<Client> clients = clientRepository.findAll();
//        model.addAttribute( clients);
//        System.out.println(clients);
//        return "hello";
//    }
   @GetMapping("/sad")
    public String sad(Model model, @ModelAttribute Client client){
        List<Client>clients = clientRepository.findAll();
        model.addAttribute(clients);
        return "hello";
   }


}

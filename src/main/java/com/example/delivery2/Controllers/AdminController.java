package com.example.delivery2.Controllers;

import com.example.delivery2.Enums.RequestStatus;
import com.example.delivery2.Enums.Roles;
import com.example.delivery2.Services.Impl.*;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Request;
import com.example.delivery2.repositories.ZakazRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    ClientServiceImpl clientService;
    RequestServiceImpl requestService;
    DistributorServiceImpl distributorService;
    GoodsServiceImpl goodsService;
    ZakazServiceImpl zakazService;
    RegistrationServiceImpl registrationService;
    @GetMapping
    public String admin(Model model){
        model.addAttribute("client",clientService.currentUser().get());
        model.addAttribute("requests", requestService.findByRequestStatus(RequestStatus.Considered));
        model.addAttribute("distributors", distributorService.findAll());
        model.addAttribute("goodsService",goodsService);
        model.addAttribute("delivers", clientService.findByRoles(Roles.ROLE_DELIVER));
        model.addAttribute("deliver_number", clientService.countByRoles(Roles.ROLE_DELIVER));
        model.addAttribute("client_number", clientService.countByRoles(Roles.ROLE_USER));
        model.addAttribute("number_zakaz", zakazService.countByDeliver(clientService.currentUser().get()));
        model.addAttribute("salary", zakazService.countSalary(clientService.currentUser().get().getId()));
        return "admin/admin";
    }
    @PostMapping("/request/approve/{id}")
    public String requestApprove(@PathVariable Long id){
        Request request = requestService.findById(id);
        request.setRequestStatus(RequestStatus.Approved);
        Client client = request.getClient();
        if(client.getRoles().equals(Roles.ROLE_USER)){
            client.setRoles(Roles.ROLE_DELIVER);
        }
        requestService.save(request);
        clientService.save(client);
        return "redirect:/api/v1/admin";
    }
    @PostMapping("/request/decline/{id}")
    public String requestDecline(@PathVariable Long id){
        Request request = requestService.findById(id);
        request.setRequestStatus(RequestStatus.Declined);
        requestService.save(request);
        return "redirect:/api/v1/admin";
    }
    @PostMapping("/make/admin/{deliver_id}")
    public String makeAdmin(@PathVariable Long deliver_id){
        Client client = clientService.findById(deliver_id);
        if(client.getRoles().equals(Roles.ROLE_DELIVER)){
            client.setRoles(Roles.ROLE_ADMIN);
        }
        clientService.save(client);
        return "redirect:/api/v1/admin";
    }
    @PostMapping("/create")
    public String create(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String number){
        Client client = new Client();
        client.setUsername(username);
        client.setName(name);
        client.setNumber(number);
        client.setPassword(password);
        registrationService.createAdmin(client);
        return "redirect:/api/v1/admin";
    }
    
}

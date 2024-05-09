package com.example.delivery2.Controllers;

import com.example.delivery2.Enums.Bank;
import com.example.delivery2.Enums.RequestStatus;
import com.example.delivery2.Photos.PhotoConfig;
import com.example.delivery2.Services.Impl.ClientServiceImpl;
import com.example.delivery2.Services.Impl.EcardServiceImpl;
import com.example.delivery2.Services.Impl.RequestServiceImpl;
import com.example.delivery2.dto.UpdateUserDto;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Ecard;
import com.example.delivery2.models.Request;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/authenticated")
public class ClientController {
    ClientServiceImpl clientService;
    EcardServiceImpl ecardService;
    RequestServiceImpl requestService;
    @GetMapping("/client")
    String personalPage(Model model){
        Client client = clientService.currentUser().get();
       Optional<Ecard> ecard = ecardService.findByClient(client);
        model.addAttribute("ecard", ecard);
        model.addAttribute("banks", Bank.values());
        model.addAttribute("client", client);
//        model.addAttribute("requests",requestService.findByClient(client));
        model.addAttribute("request", requestService.findRequest(client.getId()));
        return "personalPage";
    }
    @PostMapping("/client/edit/{client_id}")
    String editMe(@PathVariable Long client_id, @RequestParam(required = false) String username, @RequestParam(required = false) String name, @RequestParam(required = false) String number){
        UpdateUserDto userDto = new UpdateUserDto(name,username,number);
        clientService.edit(userDto, clientService.findById(client_id));

        return "redirect:/auth/login";

    }
    @PostMapping("client/change/photo/{id}")
    String changeImage(@PathVariable Long id, @RequestParam("image") MultipartFile multipartFile){
        PhotoConfig photoConfig = new PhotoConfig();
        photoConfig.savePhoto(multipartFile);
        Client client = clientService.findById(id);
        client.setPhoto("images/"+multipartFile.getOriginalFilename());
        clientService.save(client);
        return "redirect:/api/v1/authenticated/client";
    }
//
    @PostMapping("/client/request/{client_id}")
    String request(@PathVariable Long client_id){
        Request request = new Request();
        request.setRequestStatus(RequestStatus.Considered);
        request.setClient(clientService.findById(client_id));
        requestService.save(request);
        return "redirect:/api/v1/authenticated/client";
    }




}

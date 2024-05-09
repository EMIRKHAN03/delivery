package com.example.delivery2.Controllers;

import com.example.delivery2.Converters.StringToLocalDateConverter;
import com.example.delivery2.Services.Impl.ClientServiceImpl;
import com.example.delivery2.Services.Impl.EcardServiceImpl;
import com.example.delivery2.models.Ecard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequestMapping("api/v1/card")
@Controller
@AllArgsConstructor
public class EcardController {
    ClientServiceImpl clientService;
    EcardServiceImpl ecardService;
    @PostMapping("/add/card")
    public String addCard(@RequestParam Long inn, @RequestParam String bankName, @RequestParam String date){
        StringToLocalDateConverter stringToLocalDateConverter = new StringToLocalDateConverter();
        LocalDate date1 = stringToLocalDateConverter.convert(date);
        Ecard ecard =  new Ecard(inn,date1,bankName);
        ecard.setClient(clientService.currentUser().get());
        ecardService.save(ecard);
        return "redirect:/api/v1/authenticated/client";
    }
    @PostMapping("/delete/card/{id}")
    public String deleteCard(@PathVariable Long id){
        ecardService.deleteCard(id);
        return "redirect:/api/v1/authenticated/client";
    }

}

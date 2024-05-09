package com.example.delivery2.Controllers;

import com.example.delivery2.Enums.ZakazStatus;
import com.example.delivery2.Services.Impl.ClientServiceImpl;
import com.example.delivery2.Services.Impl.ZakazGoodServiceImpl;
import com.example.delivery2.Services.Impl.ZakazServiceImpl;
import com.example.delivery2.models.Client;
import com.example.delivery2.models.Zakaz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/deliver")
@AllArgsConstructor
public class DeliverController {
    ZakazServiceImpl zakazService;
    ZakazGoodServiceImpl zakazGoodService;
    ClientServiceImpl clientService;

    @GetMapping
    String deliver(Model model){
        Client deliver = clientService.currentUser().get();
        model.addAttribute(deliver);
        List<Zakaz> zakazList = zakazService.findByZakazStatusAndDeliver(ZakazStatus.Received, null);
        model.addAttribute(zakazList);
        model.addAttribute("salary", zakazService.countSalary(deliver.getId()));
        model.addAttribute("zakazGoodService", zakazGoodService);
        model.addAttribute("zakazList1",zakazService.findByZakazStatusAndDeliver(ZakazStatus.Delivered, clientService.currentUser().get()));
        model.addAttribute("myZakazlist", zakazService.findByZakazStatusAndDeliver(ZakazStatus.Processed, clientService.currentUser().get()));
        return "deliver/deliver";
    }




}

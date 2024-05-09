package com.example.delivery2.Controllers;

import com.example.delivery2.Enums.Payment;
import com.example.delivery2.Enums.ZakazStatus;
import com.example.delivery2.Services.Impl.ClientServiceImpl;
import com.example.delivery2.Services.Impl.ZakazGoodServiceImpl;
import com.example.delivery2.Services.Impl.ZakazServiceImpl;
import com.example.delivery2.dto.ZakazDto;
import com.example.delivery2.models.Zakaz;
import com.example.delivery2.models.ZakazGood;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/api/v1/authenticated")
@AllArgsConstructor
public class ZakazController {
    ZakazServiceImpl zakazService;
    ZakazGoodServiceImpl zakazGoodService;
    ClientServiceImpl clientService;
    @GetMapping("/zakaz/all")
    public String allZakazs(Model model){
        model.addAttribute("zakazList",zakazService.findByClientAndZakazStatusNotLikeAndZakazStatusNotLike(clientService.currentUser().get(), ZakazStatus.Delivered, ZakazStatus.Declined));
        model.addAttribute("zakazGoodService", zakazGoodService);
        return "bin";
    }
    @PostMapping("/zakaz/dead/{id}")
    public String killZakaz( @PathVariable Long id) throws Exception {
        Zakaz zakaz = zakazService.findById(id);
        zakaz.setZakazStatus(ZakazStatus.Declined);
        zakazService.save(zakaz);
        return "redirect:/api/v1/authenticated/zakaz/all";
    }
    @PostMapping("/deliver/take/zakaz/{zakaz_id}")
    public String takeZakaz(@PathVariable Long zakaz_id) throws Exception {
        Zakaz zakaz = zakazService.findById(zakaz_id);
        zakaz.setDeliver(clientService.currentUser().get());
        zakaz.setZakazStatus(ZakazStatus.Processed);
        zakazService.save(zakaz);
        return "redirect:/api/v1/deliver";
    }
    @PostMapping("/deliver/deliver/{zakaz_id}")
    public String deliverZakaz(@PathVariable Long zakaz_id) throws Exception {
        Zakaz zakaz = zakazService.findById(zakaz_id);
        zakaz.setZakazStatus(ZakazStatus.Delivered);
        zakazService.save(zakaz);
        return "redirect:/api/v1/deliver";
    }
    @PostMapping("/deliver/decline/{zakaz_id}")
    public String declineDelivery(@PathVariable Long zakaz_id) throws Exception {
        Zakaz zakaz = zakazService.findById(zakaz_id);
        zakaz.setZakazStatus(ZakazStatus.Received);
        zakaz.setDeliver(null);
        zakazService.save(zakaz);
        return "redirect:/api/v1/deliver";
    }

    @PostMapping(value = "zakaz/make/{distributor_id}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String makeZakaz(ZakazDto zakazDto,@PathVariable Long distributor_id){
        List<ZakazGood> zakazGoods = zakazGoodService.findByZakaz(null);
        zakazService.setZakazGood(zakazGoods,zakazDto.getAddress(),zakazDto.getPayment(), distributor_id);
        return "redirect:/api/v1/authenticated/zakaz/all";

    }
}

package com.promos.PROMO_Orange.Controller;

import com.promos.PROMO_Orange.BL.PromoBL;
import com.promos.PROMO_Orange.Model.Requests;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Promo")
public class PromoController {

    private final PromoBL promoBL;


    public PromoController(PromoBL promoBL) {
        this.promoBL = promoBL;
    }

    @GetMapping
    public Requests getPromoRequest(@RequestParam int msisdn, @RequestParam int offerid ) {
        return promoBL.getPromoRequest(msisdn,offerid);
    }
   // GET https://localhost:8080/Promo
}

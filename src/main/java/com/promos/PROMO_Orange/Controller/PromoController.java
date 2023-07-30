package com.promos.PROMO_Orange.Controller;

import com.promos.PROMO_Orange.BL.PromoBL;
import com.promos.PROMO_Orange.Model.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Promo")
public class PromoController {
    @Autowired
    private PromoBL promoBL;

    public PromoController(PromoBL promoBL) {
        this.promoBL = promoBL;
    }

    @GetMapping
    public String getPromoRequest(@RequestParam Long msisdn, @RequestParam Long offerid ) {
        return promoBL.Flow(msisdn,offerid);
    }
   // http://localhost:8080/Promo?msisdn=0123456&offerid=23
}

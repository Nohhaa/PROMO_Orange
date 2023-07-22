package com.promos.PROMO_Orange.Controller;

import com.promos.PROMO_Orange.BL.PromoBL;
import com.promos.PROMO_Orange.Model.Requests;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Promo")
public class PromoController {

    private final PromoBL promoBL;


    public PromoController(PromoBL promoBL) {
        this.promoBL = promoBL;
    }

    @GetMapping
    public Requests getPromoRequest(@PathVariable int msisdn, int offerid ) {
        return promoBL.getPromoRequest(msisdn,offerid);
    }
}

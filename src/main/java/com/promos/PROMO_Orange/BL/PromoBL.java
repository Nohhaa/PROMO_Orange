package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.Requests;
import org.springframework.stereotype.Service;

@Service
public class PromoBL {
    private final Requests Req;

    public PromoBL(Requests req) {
        Req = req;
    }

    public Requests getPromoRequest(int msisdn, int offerId) {
        Req.setofferId(offerId);
        Req.setMsisdn(msisdn);
        return Req;

    }
}
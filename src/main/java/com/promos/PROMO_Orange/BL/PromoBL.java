package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.*;
import org.springframework.stereotype.Service;

@Service
public class PromoBL {
    private final Requests Req;
    private final Customer Cus;
    private final Fulfillment Ful;
    private final Offer Off;
    private final Segmentation Seg;

    public PromoBL(Requests req, Customer cus, Fulfillment ful, Offer off, Segmentation seg) {
        Req = req;
        Cus = cus;
        Ful = ful;
        Off = off;
        Seg = seg;
    }

    public Requests getPromoRequest(int msisdn, int offerId) {
        Req.setofferId(offerId);
        Req.setMsisdn(msisdn);
        System.out.println(Req.getMsisdn()+" "+Req.getofferId());
        return Req;

    }
    public void IsCustomer(int msisdn) {
       // Cus.setId(Select id from Customer where Msisdn=msisdn);
        Cus.setMsisdn(msisdn);
        System.out.println(Req.getMsisdn()+" "+Req.getofferId());
       // return;

    }
    public void IsSegmented(int msisdn) {


    }
}
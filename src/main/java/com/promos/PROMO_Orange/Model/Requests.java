package com.promos.PROMO_Orange.Model;

import org.springframework.stereotype.Component;
@Component

public class Requests {
    private int Msisdn;
    private int offerId;


    public void setofferId(int offerid) {
        offerId = offerid;
    }
    public int getofferId() {
        return offerId;
    }

    public int getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(int msisdn) {
        Msisdn = msisdn;
    }
}

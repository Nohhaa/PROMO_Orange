package com.promos.PROMO_Orange.Model;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;



@Component



public class Requests {
    private Long Msisdn;
    private Long offerId;


    public void setofferId(Long offerid) {
        offerId = offerid;
    }
    public Long getofferId() {
        return offerId;
    }

    public Long getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(Long msisdn) {
        Msisdn = msisdn;
    }
}

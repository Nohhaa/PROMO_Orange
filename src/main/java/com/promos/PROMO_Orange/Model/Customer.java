package com.promos.PROMO_Orange.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity
@Component
public class Customer {
    private int Msisdn;
    private int Id;

    public void setId(int id) {
        Id = id;
    }
    public int getId() {
        return Id;
    }

    public int getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(int msisdn) {
        Msisdn = msisdn;
    }

}

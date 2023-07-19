package com.promos.PROMO_Orange.Model;

public class Customer {
    private int Msisdn;
    private int Id;



    public Customer(int id,int msisdn) {
        Id = id;
        Msisdn=msisdn;

    }
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

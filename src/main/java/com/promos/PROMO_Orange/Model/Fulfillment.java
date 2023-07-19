package com.promos.PROMO_Orange.Model;

public class Fulfillment {
    private int Msisdn;
    private int Id;

    private int OfferId;

    private String Status;

    private String Date;



    public Fulfillment(int id, int msisdn, int offerId, String status, String date) {
        Id = id;
        Msisdn=msisdn;
        OfferId = offerId;
        Status = status;
        Date = date;
    }

    public int getOfferId() {
        return OfferId;
    }

    public void setOfferId(int offerId) {
        OfferId = offerId;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public int getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(int msisdn) {
        Msisdn = msisdn;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}

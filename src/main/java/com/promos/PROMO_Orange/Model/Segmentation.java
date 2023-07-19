package com.promos.PROMO_Orange.Model;

public class Segmentation {

    private int Msisdn;
    private int Segment;

    private int OfferId;


    public Segmentation(int segment, int msisdn, int offerId) {
        Segment = segment;
        Msisdn=msisdn;
        OfferId = offerId;

    }

    public int getOfferId() {
        return OfferId;
    }

    public void setOfferId(int offerId) {
        OfferId = offerId;
    }

    public int getSegment() {
        return Segment;
    }

    public void setSegment(int segment) {
        Segment = segment;
    }
    public int getMsisdn() {
        return Msisdn;
    }

    public void setMsisdn(int msisdn) {
        Msisdn = msisdn;
    }

}

package com.promos.PROMO_Orange.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SegmentationId implements Serializable {
    @Column(name = "Msisdn")
    private Long msisdn;

    @Column(name = "Segment")
    private int segment;

    public SegmentationId() {

    }

    public SegmentationId(Long msisdn, int segment) {
        this.msisdn = msisdn;
        this.segment = segment;
    }


    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }
}
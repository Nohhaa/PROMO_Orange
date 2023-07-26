package com.promos.PROMO_Orange.Model;

import jakarta.persistence.*;

@Entity
public class Segmentation {

    @EmbeddedId
    private SegmentationId id;

    @ManyToOne
    @JoinColumn(name = "Msisdn", referencedColumnName = "Msisdn", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "OfferId")
    private Long offerId;

    @ManyToOne
    @JoinColumn(name = "OfferId", referencedColumnName = "Id", insertable = false, updatable = false)
    private Offer offer;


    public Segmentation() {
    }

    public Segmentation(Long msisdn, int segment, Long offerId) {
        this.id = new SegmentationId(msisdn, segment);
        this.offerId = offerId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public SegmentationId getId() {
        return id;
    }

    public void setId(SegmentationId id) {
        this.id = id;
    }
}

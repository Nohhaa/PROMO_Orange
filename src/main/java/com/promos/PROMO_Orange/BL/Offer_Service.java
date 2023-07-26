package com.promos.PROMO_Orange.BL;
import com.promos.PROMO_Orange.Model.Offer;
import com.promos.PROMO_Orange.Repositories.Offer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Offer_Service {
    private final Offer_Repo offer;

    public Offer_Service(Offer_Repo myRepository) {
        this.offer = myRepository;
    }

    public Offer SaveOffer(Offer offerr){
        return offer.save(offerr);
    }

    public Optional<Offer>fetchOfferById(Long OfferId) {
        return offer.findById(OfferId);
    }

    public Optional<Offer> findOfferById(Long OfferId) {
        return offer.findById(OfferId);
    }

    public void deleteOfferById(Long OfferId) {
        offer.deleteById(OfferId);
    }

}
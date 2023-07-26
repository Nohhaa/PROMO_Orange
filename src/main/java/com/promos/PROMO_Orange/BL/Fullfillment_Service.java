package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.Fulfillment;
import com.promos.PROMO_Orange.Repositories.Fullfillment_Repo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Fullfillment_Service {
    private final Fullfillment_Repo fullfillment;

    public Fullfillment_Service(Fullfillment_Repo fullfillment) {
        this.fullfillment = fullfillment;
    }

    public Fulfillment SaveFullfillment(Fulfillment full){
        return fullfillment.save(full);
    }

    public Optional<Fulfillment> fetchFullfillmentById(Long FullfillmentId) {
        return fullfillment.findById(FullfillmentId);
    }

    public Optional<Fulfillment> findFullfillmentById(Long FullfillmentId) {
        return fullfillment.findById(FullfillmentId);
    }

    public ArrayList<Fulfillment> findFullfillmentByMsisdn(Long Mis) {
        return fullfillment.findByMsisdn(Mis);
    }

    public void deleteFullfillmentById(Long FullfillmentId) {
        fullfillment.deleteById(FullfillmentId);
    }



}
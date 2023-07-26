package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.*;
import com.promos.PROMO_Orange.Model.Customer;
import com.promos.PROMO_Orange.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class PromoBL {
    private Requests Req;
    private Customer_Repo cus_Repo;
    private  Segmentation_Repo seg_Repo;
    private  Fullfillment_Repo full_Repo;
    private  Offer_Repo offer_Repo;


    private Customer Cus;

    public Long idBl;

    ArrayList<Segmentation> segments = new ArrayList<>();
    ArrayList<Fulfillment> Fullfilled = new ArrayList<>();
    ArrayList<Integer> SegId = new ArrayList<>();

    public PromoBL(Requests req) {
        Req = req;
    }


    public Requests getPromoRequest(Long msisdn, Long offerId) {
        Req.setofferId(offerId);
        Req.setMsisdn(msisdn);
        System.out.println(Req.getMsisdn() + " " + Req.getofferId());
        return Req;

    }


    public Boolean IsCustomer(Long msisdn) {
        Customer_Service Search = new Customer_Service();
        Cus = Search.fetchCustomerById(msisdn);
        if (Cus != null) {
            idBl = Cus.getMsisdn();
            return true;
        }
        System.out.println("NOT Customer");

        return false;
    }


    public boolean IsSegmented(Long msisdn) {
        Segmentation_Service Search = new Segmentation_Service(seg_Repo);
        segments = Search.findSegmentationByMsisdn(msisdn);

        if (segments.size() > 0) {

            for (int i = 0; i < segments.size(); i++) {
                SegId.add(segments.get(i).getId().getSegment());
            }

            return true;
        }

        return false;
    }


    public Boolean IsAvailable(Long offerId) {
        Segmentation_Service Search = new Segmentation_Service(seg_Repo);
        segments.clear();
        segments = Search.findSegmentationByOfferId(offerId);

        for (int i = 0; i < SegId.size(); i++) {
            int Sid = SegId.get(i);
            for (int j = 0; j < segments.size(); j++) {
                if (Sid == segments.get(i).getId().getSegment()) {
                    return true;
                }


            }

        }
        return false;
    }


    public Boolean IsFullfilled(Long msisdn, Long offerId) {
        Fullfillment_Service Search = new Fullfillment_Service(full_Repo);
        Fullfilled = Search.findFullfillmentByMsisdn(msisdn);


        for (int i = 0; i < Fullfilled.size(); i++) {
            if (Fullfilled.get(i).getOfferId() == offerId) {
                return false;
            }

        }

        LocalTime currentTime = LocalTime.now();
        Long id = null;
        Fulfillment fill = new Fulfillment(id, msisdn, offerId, "redeemed", "" + currentTime);

        return true;
    }


    public String Flow(Long msisdn, Long offerId) {
        ArrayList<Integer> Temp_Seg = new ArrayList<>();
        getPromoRequest(msisdn, offerId);
        if (IsCustomer(msisdn)) {
            if (IsSegmented(msisdn)) {

                if (IsAvailable(offerId)) {
                    if (!IsFullfilled(msisdn, offerId)) {
                        return "Gift already redeemed.";
                    } else {
                        return "Gift is successfully redeemed";
                    }
                } else {
                    return "offer Not available .";
                }

            } else {
                return "offer Not available .";
            }


        } else {
            return "offer Not available .";
        }

    }

}
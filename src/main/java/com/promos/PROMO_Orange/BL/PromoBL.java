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
    private final Segmentation_Service Seg_Search ;
    private final Fullfillment_Service Ful_Search;

    private final Customer_Service Cus_Search ;
    ArrayList<Integer> SegId1 = new ArrayList<>();





    @Autowired
    public PromoBL(Requests req, Segmentation_Service seg_search, Fullfillment_Service ful_search, Customer_Service cus_search) {
        Req = req;

        Seg_Search = seg_search;
        Ful_Search = ful_search;
        Cus_Search = cus_search;
    }


    public Requests getPromoRequest(Long msisdn, Long offerId) {
        Req.setofferId(offerId);
        Req.setMsisdn(msisdn);
        System.out.println(Req.getMsisdn() + " " + Req.getofferId());
        return Req;

    }


    public Boolean IsCustomer(Long msisdn) {

        Cus = Cus_Search.fetchCustomerById(msisdn);
        if (Cus != null) {
            idBl = Cus.getMsisdn();
            return true;
        }
        System.out.println("NOT Customer");

        return false;
    }


    public boolean IsSegmented(Long msisdn) {
        ArrayList<Segmentation> segments=new ArrayList<>();

        segments = Seg_Search.findSegmentationByMsisdn(msisdn);

        if (segments.size() > 0) {

            for (int i = 0; i < segments.size(); i++) {
                SegId1.add(segments.get(i).getId().getSegment());
            }

            return true;
        }

        return false;
    }


    public Boolean IsAvailable(Long offerId) {

        ArrayList<Segmentation> segments2=new ArrayList<>();

        segments2 = Seg_Search.findSegmentationByOfferId(offerId);

        for (int i = 0; i < SegId1.size(); i++) {
            int Sid = SegId1.get(i);
            for (int j = 0; j < segments2.size(); j++) {
                if (Sid == segments2.get(i).getId().getSegment()) {
                    SegId1.clear();
                    return true;
                }


            }

        }
        SegId1.clear();
        return false;
    }


    public Boolean IsFullfilled(Long msisdn, Long offerId) {
        ArrayList<Fulfillment> Fullfilled = new ArrayList<>();
        Fullfilled = Ful_Search.findFullfillmentByMsisdn(msisdn);


        for (int i = 0; i < Fullfilled.size(); i++) {
            if (Fullfilled.get(i).getOfferId() == offerId) {
                return false;
            }

        }

        LocalTime currentTime = LocalTime.now();
        int id=0;
        Fulfillment fill = new Fulfillment((long)id, msisdn, offerId, "redeemed", "" + currentTime);
        Ful_Search.SaveFullfillment(fill);

        return true;
    }


    public String Flow(Long msisdn, Long offerId) {

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
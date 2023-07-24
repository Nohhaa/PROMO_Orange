package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.*;
import com.promos.PROMO_Orange.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PromoBL {
    private final Requests Req;
    private final Customer Cus;

    private final Fulfillment Ful;
    private final Offer Off;
    private final Segmentation Seg;
    public int idBl;
    public int offer_Avail;
    public int fulId;

    ArrayList<Integer> segments = new ArrayList<>();
    public PromoBL(Requests req, Customer cus, Fulfillment ful, Offer off, Segmentation seg) {
        Req = req;
        Cus = cus;
        Ful = ful;
        Off = off;
        Seg = seg;
    }

    public Requests getPromoRequest(int msisdn, int offerId) {
        Req.setofferId(offerId);
        Req.setMsisdn(msisdn);
        System.out.println(Req.getMsisdn()+" "+Req.getofferId());
        return Req;

    }
    public Customer IsCustomer(int msisdn) {

       // idBl=(Select id from Customer where Msisdn=msisdn);

        if(idBl!=1) {
            Cus.setMsisdn(msisdn);
            Cus.setId(idBl);
            //System.out.println(Req.getMsisdn() + " " + Req.getofferId());
            return Cus;
        }
        else {
            return null;
        }
    }
    public ArrayList<Integer> IsSegmented(Customer cus) {
        // segments=(Select Segment from Segmentation where Msisdn= cus.getmsisdn());

        if(segments.size()>0) {

            return segments;
        }
        else {
            return null;
        }

    }
    public Boolean IsAvailable(int offerId, ArrayList<Integer> segments) {

        for(int i=0;i<segments.size();i++)
        {
            //offer_Avail = (select offerid from Segmentation where segment=segments[i]

            if (offer_Avail != 1) {

                return true;
            }
        }
        return false;
    }
    public Boolean IsFulfilled(int msisdn, int offerId) {
        //fulId = (select id from Fulfillment where Msisdn=msisdn and offerId=offerId)

            if (fulId != 1)
            {
                return true;
            }
       else
        return false;
    }
}
package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.Offer;
import com.promos.PROMO_Orange.Model.Segmentation;
import com.promos.PROMO_Orange.Model.SegmentationId;
import com.promos.PROMO_Orange.Repositories.Segmentation_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Segmentation_Service {
    private final Segmentation_Repo segmentation;

    public Segmentation_Service(Segmentation_Repo myRepository) {
        this.segmentation = myRepository;
    }


    public Segmentation SaveSegmentation(Segmentation seg){
        return segmentation.save(seg);
    }

    public ArrayList<Segmentation> findSegmentationByMsisdn(Long Mis) {
        return segmentation.findByMsisdn(Mis);
    }

    public ArrayList<Segmentation> findSegmentationByOfferId(Long OfferId) {
        return segmentation.findByOfferId(OfferId);
    }

    public void deleteSegmentationById(SegmentationId segmentationId) {
        segmentation.deleteById(segmentationId);
    }


}
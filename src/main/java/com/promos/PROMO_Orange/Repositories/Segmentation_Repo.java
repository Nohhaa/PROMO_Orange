package com.promos.PROMO_Orange.Repositories;

import com.promos.PROMO_Orange.Model.Segmentation;
import com.promos.PROMO_Orange.Model.SegmentationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface Segmentation_Repo extends JpaRepository<Segmentation,Long> {
    @Query("SELECT s FROM Segmentation s WHERE s.id.msisdn = :msisdn")
    ArrayList<Segmentation> findByMsisdn(Long msisdn);
    ArrayList<Segmentation> findByOfferId(Long offerId);

    void deleteById(SegmentationId segmentationId);
}
package com.promos.PROMO_Orange.Repositories;


import com.promos.PROMO_Orange.Model.Fulfillment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface Fullfillment_Repo extends JpaRepository<Fulfillment,Long> {

    ArrayList<Fulfillment> findByMsisdn(Long mis);
}
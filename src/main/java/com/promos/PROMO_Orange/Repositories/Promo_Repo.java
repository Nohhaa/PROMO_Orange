package com.promos.PROMO_Orange.Repositories;

import com.promos.PROMO_Orange.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Promo_Repo extends JpaRepository<Offer,Long> {

}

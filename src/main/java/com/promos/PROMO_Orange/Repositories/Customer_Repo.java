package com.promos.PROMO_Orange.Repositories;

import com.promos.PROMO_Orange.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Customer_Repo extends JpaRepository<Customer,Long> {

}
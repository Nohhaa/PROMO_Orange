package com.promos.PROMO_Orange.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.support.Repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Column;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder



public class Customer {

    @Column(name = "Msisdn")
    private Long msisdn;

    @Column(name = "Id")
    private Long id;


    public void setId(long Id) {
        id = Id;

    }


    public long getId() {
        return id;
    }

    @Id
    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this. msisdn = msisdn;
    }





}

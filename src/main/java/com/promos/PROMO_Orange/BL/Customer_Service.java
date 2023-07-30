package com.promos.PROMO_Orange.BL;

import com.promos.PROMO_Orange.Model.Customer;
import com.promos.PROMO_Orange.Repositories.Customer_Repo;
import com.promos.PROMO_Orange.Repositories.Fullfillment_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Objects;
@Service
public class Customer_Service {

    private Customer_Repo customer_R=null;

    @Autowired
    public Customer_Service(Customer_Repo customer) {
        this.customer_R = customer;
    }
    public Customer SaveCustomer(Customer Cust){
        return customer_R.save(Cust);
    }

    public Customer fetchCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customer_R.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        return customer_R.findById(customerId);
    }

    public void deleteCustomerById(Long customerId) {
        customer_R.deleteById(customerId);
    }

}
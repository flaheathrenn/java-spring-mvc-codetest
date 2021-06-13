package com.example.demo.services;

import com.example.demo.models.Customer;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CustomersService {

    /**
     * Sort a list of Customer objects by duetime from oldest to newest.
     * This method modifies the object passed to it.
     *
     * @param customers a List of Customers to be sorted
     */
    public void sortAscendingDuetime(List<Customer> customers) {
        customers.sort(Comparator.comparing(Customer::getDuetime));
    }
}

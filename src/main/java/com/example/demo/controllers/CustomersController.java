package com.example.demo.controllers;

import com.example.demo.models.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {

    /**
     * @param customers a List of Customer objects
     * @return a List of Customer objects containing all the same objects as input, sorted by duetime from oldest to newest
     */
    @PostMapping("/customers/sort")
    public List<Customer> sortAscendingDuetime(@RequestBody List<Customer> customers) {
        System.out.println("Received " + customers.size() + " customers"); // would normally use a proper logging framework here
        return customers;
    }
}

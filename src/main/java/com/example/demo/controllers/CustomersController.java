package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    /**
     * @param customers a List of Customer objects
     * @return a List of Customer objects containing all the same objects as input, sorted by duetime from oldest to newest
     */
    @PostMapping("/customers/sort")
    @Async
    public CompletableFuture<List<Customer>> sortAscendingDuetime(@RequestBody List<Customer> customers) {
        customersService.sortAscendingDuetime(customers);
        return CompletableFuture.completedFuture(customers);
    }
}

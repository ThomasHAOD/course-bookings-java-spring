package com.codeclan.example.coursebooking.repositories.customerRepository;

import com.codeclan.example.coursebooking.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findCustomersByCourse(Long courseId);


}

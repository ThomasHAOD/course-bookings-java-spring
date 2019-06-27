package com.codeclan.example.coursebooking.controllers;

import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.customerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> findCustomersByCourse(@PathVariable Long courseId){
        return customerRepository.findCustomersByCourse(courseId);
    }

    @GetMapping(value = "/town/{town}/course/{id}")
    public List<Customer> findCustomersByTownAndBookings_CourseId(@PathVariable String town, @PathVariable Long id){
        String formattedString = StringUtils.capitalize(town);
        return  customerRepository.findCustomersByTownAndBookings_CourseId(formattedString, id);
    }

    @GetMapping(value = "/town/{town}/age/{age}/course/{id}")
    public List<Customer> findCustomersByTownAndAgeAndBookings_CourseId(@PathVariable String town, @PathVariable int age, @PathVariable Long id){
        String formattedString = StringUtils.capitalize(town);
        return  customerRepository.findCustomersByTownAndAgeAndBookings_CourseId(formattedString, age, id);
    }

}

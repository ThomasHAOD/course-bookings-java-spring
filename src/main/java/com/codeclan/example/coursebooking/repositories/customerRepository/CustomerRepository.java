package com.codeclan.example.coursebooking.repositories.customerRepository;

import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    List<Customer> findCustomersByTownAndBookings_CourseId(String town, Long id);

    List<Customer> findCustomersByTownAndAgeAndBookings_CourseId(String town, int age, Long id);

}

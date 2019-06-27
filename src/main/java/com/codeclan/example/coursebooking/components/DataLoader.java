package com.codeclan.example.coursebooking.components;

import com.codeclan.example.coursebooking.models.Booking;
import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import com.codeclan.example.coursebooking.repositories.bookingRepository.BookingRepository;
import com.codeclan.example.coursebooking.repositories.courseRepository.CourseRepository;
import com.codeclan.example.coursebooking.repositories.customerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Jim", "Edinburgh", 19);
        Customer customer2 = new Customer("Jom", "Glasgow", 18);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Course course1 = new Course("JavaSpring", "Edinburgh", 1);
        Course course2 = new Course("JavaScript", "Glasgow", 3);
        courseRepository.save(course1);
        courseRepository.save(course2);

        Booking booking1 = new Booking("12-02-1029", course1, customer1);
        Booking booking2 = new Booking("12-02-1029", course2, customer2);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
    }

}

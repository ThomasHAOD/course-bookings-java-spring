package com.codeclan.example.coursebooking.repositories.customerRepository;

import com.codeclan.example.coursebooking.models.Booking;
import com.codeclan.example.coursebooking.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Customer> findCustomersByCourse(Long courseId) {
        List<Customer> customers = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingsAlias");
            cr.add(Restrictions.eq("bookingsAlias.course.id", courseId));
            customers = cr.list();
        } catch (HibernateError ex){
            ex.printStackTrace();
        } finally {
        }

        return customers;
    }
}

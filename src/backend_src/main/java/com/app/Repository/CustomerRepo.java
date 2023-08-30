package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Long>{

// Optional<Customer> findByUsername(String Customername);
 Customer findByUsername(String username);
 
 boolean existsByCustomerId(long id);
 
 Optional<Customer> findByCustomerId(Long id);
 
 boolean existsByEmail(String email);
 
 boolean existsByUsername(String userName);
 
Optional<Customer> findByEmail(String email);
 
 Optional<Customer> findByEmailAndPassword(String email, String password);
 
 Customer findByReservationsRid(long id);
 
// @Query("SELECT r FROM Reservation r WHERE r.Customer.customerId=:id")
// List<Reservation> getReservationCustomer(@Param("id") long id);
 
}

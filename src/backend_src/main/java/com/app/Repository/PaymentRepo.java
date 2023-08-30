package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

	List<Payment> findByAmount(double amount);
}

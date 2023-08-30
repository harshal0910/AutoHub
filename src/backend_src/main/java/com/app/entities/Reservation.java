package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor

@Setter
@Getter
@ToString

@Entity
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private Long rid;
	
	private LocalDate bookingDate;
	
	 @Column(name = "start_Date")
	@FutureOrPresent
	private LocalDate startDate;
	
	 @Column(name = "end_Date")
	@Future
	private LocalDate endDate;
	
	 @Column(length=100)
	private String pickUpLocation;
	private double rentalPrice;
	private double penalty;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="customer_id")
	private Customer customer;

	 
	 
	 public Reservation(Vehicle vehicle, Customer customer, LocalDate startDate,LocalDate endDate, String pickupLocation,
				 double rentalPrice) {
			super();
			this.vehicle = vehicle;
			this.customer = customer;
			this.bookingDate= LocalDate.now();
			this.startDate= startDate;
			this.endDate = endDate;
			this.pickUpLocation=pickupLocation;
			this.rentalPrice = rentalPrice;
//			this.paymentId=paymentId;
		}
	 
	 public Reservation()
	 {
		 this.bookingDate=LocalDate.now();
	 }

}

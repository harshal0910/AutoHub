
package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long paymentId;
	@NotNull(message = "invalid Amount")
	private double amount;
	
	private boolean paymentStatus=false;
	
	 @Column(name = "payment_DateTime")
	private LocalDateTime paymentDate = LocalDateTime.now();
	@OneToOne
    @JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	
	

}

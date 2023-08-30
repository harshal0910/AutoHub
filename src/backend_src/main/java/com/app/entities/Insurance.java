package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Embeddable
public class Insurance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="insurance_id")
    private long insuranceid;
	@NotNull
	private String provider;
	 @Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	
	
	
	
}

package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="location_id")
	private Long locationId;
	private String city;
	
//	 @OneToOne(mappedBy = "pickup_location", cascade = CascadeType.ALL)
//	    private Reservation reservation;
	 
}

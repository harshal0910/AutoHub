package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vehicle_id")
    private long vid;
	@Enumerated(EnumType.STRING)
	private Type vehicleType;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private double rate;
    private boolean availability=true;
    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,
    		orphanRemoval = true)
    private List<Reservation> reservation;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;
    
    @OneToOne
    @JoinColumn(name="insurance_id")
    private Insurance insurance;
   
    



}

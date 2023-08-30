package com.app.entities;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "reservations")

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotNull
	private String username;
	
	@Column(name = "first_name",length=50,nullable = false)
	private String firstName;
	
	@Column(name = "last_name",length=50,nullable = false)
	private String lastName;
	
	@Column(length = 10,unique=true)
	private String contact;
	
	@Column(nullable=false,unique = true)
	@Email(message = "Email is not valid")
	private String email;
	
	@Column(name="driving_license_number",nullable=false)
	private String drivingLicenseNumber;
	
	@Column(name="credit_card_details",nullable = false)
	private String creditCardDetails;
	
	private String address;
	
	@NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
	
	 @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval = true)
	 private List<Reservation> reservations = new ArrayList<>();
	   
	 
	
	 
	 public void setReservations(Reservation reservations) {
	        this.reservations.add(reservations);
	    }




	public Customer( @NotNull String username, String firstName, String lastName, String contact,
			@Email(message = "Email is not valid") String email, String drivingLicenseNumber, String creditCardDetails,
			String address,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String password) {
		super();
		
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.drivingLicenseNumber = drivingLicenseNumber;
		this.creditCardDetails = creditCardDetails;
		this.address = address;
		this.password = password;
	}
}

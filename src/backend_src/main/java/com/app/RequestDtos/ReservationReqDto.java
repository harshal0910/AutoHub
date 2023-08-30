package com.app.RequestDtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.app.entities.Vehicle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationReqDto implements Serializable {

//	    @NotBlank
	    private String userName;
	    
	    @NotBlank
	    private long vId;
	    

//	    @NotBlank
	    private String endDate;
	    
//	    @NotBlank
	    private String startDate;
	    
//	    @NotBlank
	    private String pickupLocation;
	    
//	    @NotBlank
	    private PaymentReqDto payment;
	
}

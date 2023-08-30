package com.app.RespDtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationRespDto implements Serializable {

	private long rid;
	
	private VehicleResponseDto vehicleResponseDto;
	
	private String startDate;
	
	private String endDate;
	
	private LocationResponseDto pickupLocation;
	
	private double amount;
}

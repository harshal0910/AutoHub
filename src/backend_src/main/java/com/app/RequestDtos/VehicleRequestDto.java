package com.app.RequestDtos;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class VehicleRequestDto implements Serializable{


	
    private String brand;

    private String model;

    private String category;

    private String vehicleType;
    
    private String city;

    private double rate;
    
    private Long insurance;
	
}

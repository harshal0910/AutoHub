package com.app.RespDtos;

import java.io.Serializable;

import com.app.entities.Location;
import com.app.entities.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponseDto implements Serializable{

	 private long vid;
	 
	    private String brand;
	    
	    private String model;
	    
	    private Type type;
	    
	    private String category;
	    
	    private double rate;
	   
	   
	    
	    private Location location;
	    
	   
}

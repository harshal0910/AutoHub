package com.app.RespDtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PaymentRespDto {

	private Long paymentId;
	
	private double Amount;
	
	private boolean paymentStatus;
	
	private LocalDateTime paymentDate;
}

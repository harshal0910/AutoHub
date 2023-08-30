package com.app.services;

import java.text.ParseException;
import java.util.List;

import com.app.RequestDtos.ReservationReqDto;
import com.app.RespDtos.ReservationRespDto;
import com.app.entities.Customer;
import com.app.entities.Reservation;
import com.app.exceptions.IncorrectDataException;

public interface ReservationService {

	ReservationRespDto getByreservationId(long id);
	
	void deleteByreservationId(long id);
	
	ReservationRespDto createBooking(ReservationReqDto reservationRequest);
	
//	List<ReservationRespDto> getCurrentReservation(long id) throws IncorrectDataException;
	
	List<ReservationRespDto> getAllReservations();

	List<ReservationRespDto> findByVID(long id);
	
//	ReservationRespDto save(ReservationReqDto reservationReqDto) throws IncorrectDataException, ParseException;
}

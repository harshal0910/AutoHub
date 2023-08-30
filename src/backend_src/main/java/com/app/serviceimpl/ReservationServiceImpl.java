package com.app.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.CustomerRepo;
import com.app.Repository.LocationRepo;
import com.app.Repository.PaymentRepo;
import com.app.Repository.ReservationRepo;
import com.app.Repository.VehicleRepo;
import com.app.RequestDtos.ReservationReqDto;
import com.app.RespDtos.ReservationRespDto;
import com.app.entities.Customer;
import com.app.entities.Payment;
import com.app.entities.Reservation;
import com.app.entities.Vehicle;
import com.app.services.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepo reservationRepo;
	@Autowired
	private CustomerRepo CustomerRepo;
	@Autowired
	private VehicleRepo VehicleRepo;
	@Autowired
	private LocationRepo locationRepo;
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ReservationRespDto getByreservationId(long id) {
		// TODO Auto-generated method stub
		return reservationToDto(reservationRepo.findById(id).get());
	}

	@Override
	public void deleteByreservationId(long id) {
		// TODO Auto-generated method stub
		this.reservationRepo.deleteById(id);
		
	}


	@Override
	public List<ReservationRespDto> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationRepo.findAll().stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
	}

	@Override
	public List<ReservationRespDto> findByVID(long id) {
		// TODO Auto-generated method stub
		return reservationRepo.findByVehicleVid(id).stream().map(reservation -> reservationToDto(reservation)).collect(Collectors.toList());
	}


	public Reservation dtotoReservation(ReservationReqDto reservationReqDto)
	{
		return this.modelMapper.map(reservationReqDto, Reservation.class);
	}
	
	public ReservationRespDto reservationToDto(Reservation reservation)
	{
		return this.modelMapper.map(reservation, ReservationRespDto.class);
	}

	@Override
	public ReservationRespDto createBooking(ReservationReqDto reservationRequest) {
	
		
		Customer fetchedcustomer= CustomerRepo.findByUsername(reservationRequest.getUserName());
		
		Reservation reservation=new Reservation();
		reservation.setCustomer(fetchedcustomer);
		Vehicle vehicle=VehicleRepo.findByVid(reservationRequest.getVId());
		reservation.setVehicle(vehicle);

    	 LocalDate startDate = LocalDate.parse(reservationRequest.getStartDate());
    	 LocalDate endDate=LocalDate.parse(reservationRequest.getEndDate());
		
		reservation.setStartDate(startDate);
		reservation.setEndDate(endDate);
		reservation.setPickUpLocation(reservationRequest.getPickupLocation());
		Reservation savedReservation=reservationRepo.save(reservation);
		Payment payment=new Payment();
		payment.setReservation(savedReservation);
		payment.setPaymentDate(LocalDateTime.now());
		payment.setPaymentStatus(true);
		payment.setAmount(reservationRequest.getPayment().getAmount());
		paymentRepo.save(payment);
		
		return reservationToDto(reservation);
		
		
	}

}

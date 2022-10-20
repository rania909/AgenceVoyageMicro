package com.esprit.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.Repositories.ReservationRepository;
import com.esprit.microservice.entities.Reservation;


@Service
public class Reservationservice {
	@Autowired
private ReservationRepository reservationRepository;
	
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);

	}
	public List<Reservation> getAllReservation() {

		return reservationRepository.findAll();
	}
	
	public Reservation getByIdReservation(int id) {
		Reservation r = reservationRepository.findById(id).get();

		return r;
	}

	public String deleteReservation(int id) {

		if (reservationRepository.findById(id).isPresent()) {
			reservationRepository.deleteById(id);
			return "reservation supprimé";
		}
		else
			return " reservation non supprimé";
	}

	public Reservation updateReservation(int id, Reservation a) {

		if (reservationRepository.findById(id).isPresent()) {
			Reservation existingReservation = reservationRepository.findById(id).get();
			existingReservation.setDateReservation(a.getDateReservation());
			existingReservation.setDuree(a.getDuree());
			existingReservation.setHeureReservation(a.getHeureReservation());
			return reservationRepository.save(existingReservation);

		}
		else
			return null;

	}

}
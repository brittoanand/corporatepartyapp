package com.corporate.partymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corporate.partymanagement.model.Arrival;
import com.corporate.partymanagement.model.Guest;
import com.corporate.partymanagement.model.Tables;
import com.corporate.partymanagement.repository.ArrivalRepository;
import com.corporate.partymanagement.repository.GuestRepository;
import com.corporate.partymanagement.repository.TableRepository;

@Service
public class PartyManagementService {

	@Autowired
	GuestRepository guestRepository;

	@Autowired
	ArrivalRepository arrivalRepository;

	@Autowired
	TableRepository tableRepository;

	public Guest addGuest(Guest guest) {
		Tables tables = tableRepository.findById(Integer.toString(guest.getTableId()))
				.orElseThrow(() -> new RuntimeException("Table id is not present. Please add table before you book."));
		if (guest.getAccompanying_guests() + 1 > tables.getNoOfSeats()) {
			throw new RuntimeException("This table can not accommodate this guest. Please select a bigger table.");
		}
		return guestRepository.save(guest);
	}

	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}

	public Arrival addGuestArrived(Arrival arrival) {
		Tables tables = tableRepository.findById(Integer.toString(arrival.getTableId()))
				.orElseThrow(() -> new RuntimeException("Table id is not present. Please select the correct table."));
		if (arrival.getAccompanying_guests() + 1 > tables.getNoOfSeats()) {
			throw new RuntimeException(
					"Sorry we can not accommodate this guest as the number of guests is more than the table can accommodate.");
		}
		return arrivalRepository.save(arrival);
	}

	public void removeGuest(String name) {
		arrivalRepository.deleteById(name);
	}

	public List<Arrival> getAllArrivedGuests() {
		return arrivalRepository.findAll();
	}

	public int getEmptySeats() {
		return arrivalRepository.getEmptySeats();
	}

	public Tables addTable(Tables tables) {
		return tableRepository.save(tables);
	}

	public List<Tables> getAllTables() {
		return tableRepository.findAll();
	}

	public void deleteTable(String tableId) {
		tableRepository.deleteById(tableId);
	}
}

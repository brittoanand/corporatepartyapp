package com.corporate.partymanagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corporate.partymanagement.model.Arrival;
import com.corporate.partymanagement.model.Guest;
import com.corporate.partymanagement.model.Tables;
import com.corporate.partymanagement.response.ArrivalListResponse;
import com.corporate.partymanagement.response.EmptySeatsResponse;
import com.corporate.partymanagement.response.GuestListResponse;
import com.corporate.partymanagement.response.GuestResponse;
import com.corporate.partymanagement.service.PartyManagementService;

@RestController
public class PartyManagementController {

	@Autowired
	PartyManagementService partyService;

	@PostMapping("/guest_list/{name}")
	public ResponseEntity<GuestResponse> addGuest(@PathVariable String name, @RequestBody Guest guest) {
		guest.setName(name);
		partyService.addGuest(guest);
		return new ResponseEntity<GuestResponse>(new GuestResponse(name), HttpStatus.OK);
	}

	@GetMapping("/guest_list")
	public ResponseEntity<GuestListResponse> getAllGuests() {
		List<Guest> guestList = partyService.getAllGuests();
		return new ResponseEntity<GuestListResponse>(new GuestListResponse(guestList), HttpStatus.OK);
	}

	@PutMapping("/guests/{name}")
	public ResponseEntity<GuestResponse> addGuestArrived(@PathVariable String name, @RequestBody Arrival arrival) {
		arrival.setName(name);
		arrival.setTime_arrived(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());
		partyService.addGuestArrived(arrival);
		return new ResponseEntity<GuestResponse>(new GuestResponse(name), HttpStatus.OK);
	}

	@DeleteMapping("/guests/{name}")
	public void removeGuest(@PathVariable String name) {
		partyService.removeGuest(name);
	}

	@GetMapping("/guests")
	public ResponseEntity<ArrivalListResponse> getAllArrivedGuests() {
		List<Arrival> arrivalList = partyService.getAllArrivedGuests();
		return new ResponseEntity<ArrivalListResponse>(new ArrivalListResponse(arrivalList), HttpStatus.OK);
	}

	@GetMapping("/seats_empty")
	public ResponseEntity<EmptySeatsResponse> getEmptySeats() {
		int emptySeats = partyService.getEmptySeats();
		return new ResponseEntity<EmptySeatsResponse>(new EmptySeatsResponse(emptySeats), HttpStatus.OK);
	}

	@PutMapping("/tables")
	public void addTable(@RequestBody Tables tables) {
		partyService.addTable(tables);
	}

	@GetMapping("/tables")
	public List<Tables> getAllTables() {
		return partyService.getAllTables();
	}

	@DeleteMapping("/tables/{tableId}")
	public void deleteTable(@PathVariable String tableId) {
		partyService.deleteTable(tableId);
	}
}

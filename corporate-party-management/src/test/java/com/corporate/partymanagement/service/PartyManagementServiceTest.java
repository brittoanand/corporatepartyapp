package com.corporate.partymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.corporate.partymanagement.model.Arrival;
import com.corporate.partymanagement.model.Guest;
import com.corporate.partymanagement.model.Tables;
import com.corporate.partymanagement.repository.ArrivalRepository;
import com.corporate.partymanagement.repository.GuestRepository;
import com.corporate.partymanagement.repository.TableRepository;

@ExtendWith(MockitoExtension.class)
class PartyManagementServiceTest {

	@InjectMocks
	PartyManagementService partyManagementService;

	@Mock
	GuestRepository guestRepository;

	@Mock
	ArrivalRepository arrivalRepository;

	@Mock
	TableRepository tableRepository;

	@Test
	public void testAddGuest() {
		Guest guest = new Guest("Jose", 1, 3);
		Tables table = new Tables(1, 5);

		when(tableRepository.findById("1")).thenReturn(Optional.of(table));
		when(guestRepository.save(guest)).thenReturn(guest);
		assertEquals(guest, partyManagementService.addGuest(guest));
	}

	@Test
	public void getAllGuests() {
		List<Guest> guestActual = new ArrayList<>();
		guestActual.add(new Guest("Jose", 1, 3));
		guestActual.add(new Guest("Rian", 2, 4));

		when(guestRepository.findAll()).thenReturn(guestActual);
		assertEquals(guestActual, partyManagementService.getAllGuests());
	}

	@Test
	public void addGuestArrivedTest() {
		Arrival arrival = new Arrival("Jose", 1, 3, "12:30");
		Tables table = new Tables(1, 5);

		when(tableRepository.findById("1")).thenReturn(Optional.of(table));
		when(arrivalRepository.save(arrival)).thenReturn(arrival);
		assertEquals(arrival, partyManagementService.addGuestArrived(arrival));
	}

	@Test
	public void getAllArrivedGuestsTest() {
		List<Arrival> arrivedActual = new ArrayList<>();
		arrivedActual.add(new Arrival("Jose", 1, 3, "10:30"));
		arrivedActual.add(new Arrival("Rian", 2, 4, "12:30"));

		when(arrivalRepository.findAll()).thenReturn(arrivedActual);
		assertEquals(arrivedActual, partyManagementService.getAllArrivedGuests());
	}

	@Test
	public void getEmptySeatsTest() {
		when(arrivalRepository.getEmptySeats()).thenReturn(2);
		assertEquals(2, partyManagementService.getEmptySeats());
	}
}

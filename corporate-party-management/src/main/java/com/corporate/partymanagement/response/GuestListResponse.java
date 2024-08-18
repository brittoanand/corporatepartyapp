package com.corporate.partymanagement.response;

import java.util.List;

import com.corporate.partymanagement.model.Guest;

public class GuestListResponse {

	private List<Guest> guests;

	public GuestListResponse(List<Guest> guests) {
		super();
		this.guests = guests;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

}

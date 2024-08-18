package com.corporate.partymanagement.response;

import java.util.List;

import com.corporate.partymanagement.model.Arrival;

public class ArrivalListResponse {

	private List<Arrival> guests;

	public ArrivalListResponse(List<Arrival> guests) {
		super();
		this.guests = guests;
	}

	public List<Arrival> getGuests() {
		return guests;
	}

	public void setGuests(List<Arrival> guests) {
		this.guests = guests;
	}

}

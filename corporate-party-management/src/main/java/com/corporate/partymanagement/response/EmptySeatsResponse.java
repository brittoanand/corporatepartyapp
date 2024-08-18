package com.corporate.partymanagement.response;

public class EmptySeatsResponse {

	private int seats_empty;

	public EmptySeatsResponse(int seats_empty) {
		super();
		this.seats_empty = seats_empty;
	}

	public int getSeats_empty() {
		return seats_empty;
	}

	public void setSeats_empty(int seats_empty) {
		this.seats_empty = seats_empty;
	}

}

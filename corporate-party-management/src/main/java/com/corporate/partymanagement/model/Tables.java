package com.corporate.partymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tables {

	@Id
	@GeneratedValue
	private int tableId;
	private int noOfSeats;

	public Tables() {

	}

	public Tables(int noOfSeats) {
		super();
		this.noOfSeats = noOfSeats;
	}

	public Tables(int tableId, int noOfSeats) {
		super();
		this.tableId = tableId;
		this.noOfSeats = noOfSeats;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
}

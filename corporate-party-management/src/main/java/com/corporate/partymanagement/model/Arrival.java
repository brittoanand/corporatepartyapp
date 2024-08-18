package com.corporate.partymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Arrival {

	@Id
	private String name;
	private int tableId;
	private int accompanying_guests;
	private String time_arrived;

	public Arrival() {

	}

	public Arrival(String name, int tableId, int accompanying_guests, String time_arrived) {
		super();
		this.name = name;
		this.tableId = tableId;
		this.accompanying_guests = accompanying_guests;
		this.time_arrived = time_arrived;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccompanying_guests() {
		return accompanying_guests;
	}

	public void setAccompanying_guests(int accompanying_guests) {
		this.accompanying_guests = accompanying_guests;
	}

	public String getTime_arrived() {
		return time_arrived;
	}

	public void setTime_arrived(String time_arrived) {
		this.time_arrived = time_arrived;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
}

package com.corporate.partymanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Guest {

	@Id
	private String name;
	private int tableId;
	private int accompanying_guests;

	public Guest() {

	}

	public Guest(String name, int tableId, int accompanying_guests) {
		super();
		this.name = name;
		this.tableId = tableId;
		this.accompanying_guests = accompanying_guests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getAccompanying_guests() {
		return accompanying_guests;
	}

	public void setAccompanying_guests(int accompanying_guests) {
		this.accompanying_guests = accompanying_guests;
	}
}

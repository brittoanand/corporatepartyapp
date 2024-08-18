package com.corporate.partymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.corporate.partymanagement.model.Guest;
import com.corporate.partymanagement.model.Tables;
import com.corporate.partymanagement.repository.GuestRepository;
import com.corporate.partymanagement.repository.TableRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	GuestRepository guestRepository;

	@Autowired
	TableRepository tableRepository;

	@Override
	public void run(String... args) throws Exception {

		guestRepository.save(new Guest("Kate", 1, 3));
		guestRepository.save(new Guest("Jose", 2, 4));
		guestRepository.save(new Guest("Rian", 3, 5));
		guestRepository.save(new Guest("Sam", 4, 6));

		tableRepository.save(new Tables(6));
		tableRepository.save(new Tables(8));
		tableRepository.save(new Tables(10));
		tableRepository.save(new Tables(8));
	}

}

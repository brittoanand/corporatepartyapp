package com.corporate.partymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corporate.partymanagement.model.Arrival;

@Repository
public interface ArrivalRepository extends JpaRepository<Arrival, String> {

	@Query(value = "SELECT COALESCE (SUM(A.NO_OF_SEATS), 0) - (COALESCE (SUM(B.ACCOMPANYING_GUESTS), 0) + COUNT(B.NAME)) AS EMPTY_SEATS FROM TABLES A FULL JOIN ARRIVAL B ON A.TABLE_ID = B.TABLE_ID", nativeQuery = true)
	int getEmptySeats();
}

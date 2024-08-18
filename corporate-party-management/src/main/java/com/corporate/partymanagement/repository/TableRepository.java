package com.corporate.partymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corporate.partymanagement.model.Tables;

@Repository
public interface TableRepository extends JpaRepository<Tables, String> {

}

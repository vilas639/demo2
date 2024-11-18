package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Holiday;

@Repository
public interface HolidaysRepository  extends JpaRepository<Holiday, String> {
	

}

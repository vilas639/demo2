package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person1;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person1, Integer> {

	Person1 readByEmail(String email);

}
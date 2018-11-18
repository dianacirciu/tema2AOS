package com.unitbv.lab.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitbv.lab.lab5.entity.Person;

public interface PersonRepository  extends JpaRepository<Person, Integer>{

}

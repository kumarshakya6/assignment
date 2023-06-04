package com.vipin.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipin.assignment.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	public List<Contact> findByLastName(String lastName);
	
	public List<Contact> findByFirstName(String firstName);
	
	public List<Contact> findByEmail(String email);

}

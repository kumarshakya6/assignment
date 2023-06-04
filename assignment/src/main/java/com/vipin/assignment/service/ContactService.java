package com.vipin.assignment.service;

import java.util.List;

import com.vipin.assignment.entity.Contact;

public interface ContactService {
	public List<Contact> findByLastName(String lastName);
	
	public List<Contact> findByFirstName(String firstName);
	
	public List<Contact> findByEmail(String email);
	
	public Contact findContactById(long id);
	
	public List<Contact> findAllContact();
	
	public Contact createContact(Contact contact);
	
	public Contact updateContact(Contact contact);
	
    public void deleteById(long theId);


}

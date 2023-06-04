package com.vipin.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipin.assignment.entity.Contact;
import com.vipin.assignment.exception.ResourceNotFoundException;
import com.vipin.assignment.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> findByLastName(String lastName){
		return contactRepository.findByLastName(lastName);
	}
	
	public List<Contact> findByFirstName(String firstName){
		return contactRepository.findByFirstName(firstName);
	}
	
	public List<Contact> findByEmail(String email){
		return contactRepository.findByEmail(email);
	}
	
	public Contact findContactById(long id) {
		
		return contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Did not find contact - " + id));

	}
	
	public List<Contact> findAllContact(){
		return contactRepository.findAll();
	}
	
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
		//contactRepository.sa
	}
	
	
    public void deleteById(long theId) {
         contactRepository.deleteById(theId);
    }

}

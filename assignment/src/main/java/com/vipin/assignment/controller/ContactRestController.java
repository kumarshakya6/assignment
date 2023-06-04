package com.vipin.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vipin.assignment.entity.Contact;
import com.vipin.assignment.exception.IllegalSearchParameterException;
import com.vipin.assignment.service.ContactService;

@RestController
@RequestMapping("/api/contacts")

public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Contact getContact(@PathVariable long id) {
		return contactService.findContactById(id);
	}
	
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<Contact> getContacts() {
		return contactService.findAllContact();
	}
	
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public List<Contact> searchContact(@RequestParam String filterType, @RequestParam String filterValue){
		
		if(filterType.equalsIgnoreCase("lastName")) {
			return contactService.findByLastName(filterValue);
		}else if(filterType.equalsIgnoreCase("firstName")) {
			return contactService.findByFirstName(filterValue);
		}else if(filterType.equalsIgnoreCase("email")) {
			return contactService.findByEmail(filterValue);
		}else {
			throw new IllegalSearchParameterException("Search filter type is not valid: "+ filterType);
		}
		
	}
	
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Contact createContact(@RequestBody Contact contact) {
		
		return contactService.createContact( contact);
	}
	
	
	@PutMapping("")
	@ResponseStatus(HttpStatus.OK)
	public Contact updateContact(@RequestBody Contact contact) {
		
		return contactService.updateContact(contact);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void removeContact(@PathVariable int id) {
		contactService.deleteById(id);
	}
}

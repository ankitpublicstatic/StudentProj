package org.ankit.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.ankit.domain.Contact;
import org.ankit.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Service
public class AddressBookResourceServiceMgmt implements IAddressBookService{
	
	ConcurrentMap<Integer, Contact> contacts = new ConcurrentHashMap<Integer, Contact>();
	@Autowired
	AddressRepository repo;
	
	// For Intilize sl4j Logger 
	Logger logger =LoggerFactory.getLogger(AddressBookResourceServiceMgmt.class);
	
	@Override
	 public Optional<Contact> fetchContact(Integer id) {
		logger.trace("getContact Api called for specfic id look up on Contact Registry");
		 Optional<Contact> contact = repo.findById(id);
		// return contacts.get(id);
		return contact;
	 }
	@Override
	 public List<Contact> fetchAllContact(){
		 logger.trace("getAllContact Api called for all Contact look up on Contact Registry");
		 List<Contact> contactList = (List<Contact>) repo.findAll();
		// return new ArrayList<Contact>(contacts.values());
		 return contactList;
	 }
	@Override
	 public Contact insertContact(Contact contact) {
		 logger.trace("addContact Api called for inserting Data into Address Book Contact Registry");
		 contacts.put(contact.getId(), contact);
		 return contact;
	 }
	
	 
	
}
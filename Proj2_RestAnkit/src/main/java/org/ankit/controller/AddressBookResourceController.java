package org.ankit.controller;

import java.util.List;
import java.util.Optional;

import org.ankit.domain.Contact;
import org.ankit.service.AddressBookResourceServiceMgmt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1")
public class AddressBookResourceController {
	
	@Autowired
	AddressBookResourceServiceMgmt service;
	
	// For Intilize sl4j Logger 
	Logger logger =LoggerFactory.getLogger(AddressBookResourceController.class);
	
	
	 @GetMapping("/{id}")
	 @ApiOperation(value="Find Contacts by ID",
	 notes="Provide an id to Look up specific contact from the address book",
	 response = Contact.class)
	 public Optional<Contact> getContact(@ApiParam(value = "ID value for the contact you need to retrieve", required = true) @PathVariable Integer id) {
		logger.trace("getContact Api called for specfic id look up on Contact Registry");
		 Optional<Contact> contact = service.fetchContact(id);
		// return contacts.get(id);
		return contact;
	 }
	
	 @GetMapping("/")
	 @ApiOperation(value="Find All Contacts",
	 notes="Provide only '/' uri to Look up all contact from the address book",
	 response = Contact.class)
	 public List<Contact> getAllContact(){
		 logger.trace("getAllContact Api called for all Contact look up on Contact Registry");
		 List<Contact> contactList = (List<Contact>) service.fetchAllContact();
		// return new ArrayList<Contact>(contacts.values());
		 return contactList;
	 }
	 @PostMapping("/")
	 @ApiOperation(value="Insert Contacts by Json Type Input",
	 notes="Provide all field input for inserting Data into Addrsss Book Contact Registry",
	 response = Contact.class)
	 public Contact addContact(@RequestBody Contact contact) {
		 logger.trace("addContact Api called for inserting Data into Address Book Contact Registry");
		 service.insertContact(contact);
		 return contact;
	 }
	 
	
}
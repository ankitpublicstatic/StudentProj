package org.ankit.service;

import java.util.List;
import java.util.Optional;

import org.ankit.domain.Contact;

public interface IAddressBookService {
	 public Optional<Contact> fetchContact(Integer id);
	 public List<Contact> fetchAllContact();
	 public Contact insertContact(Contact contact);
}
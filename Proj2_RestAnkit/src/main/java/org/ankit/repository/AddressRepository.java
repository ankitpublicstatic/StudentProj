package org.ankit.repository;

import org.ankit.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends CrudRepository<Contact, Integer> {

}

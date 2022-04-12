package com.ck.apmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ck.apmApp.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}

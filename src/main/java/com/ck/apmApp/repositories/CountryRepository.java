package com.ck.apmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ck.apmApp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}

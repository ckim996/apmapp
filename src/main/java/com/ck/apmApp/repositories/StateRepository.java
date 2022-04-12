package com.ck.apmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ck.apmApp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}

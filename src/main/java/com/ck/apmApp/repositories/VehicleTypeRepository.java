package com.ck.apmApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ck.apmApp.models.VehicleType;
@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

}

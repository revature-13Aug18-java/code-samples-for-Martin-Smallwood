package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Location;

/**
 * JpaRepository for the Location Object.
 * @author Small
 *
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}

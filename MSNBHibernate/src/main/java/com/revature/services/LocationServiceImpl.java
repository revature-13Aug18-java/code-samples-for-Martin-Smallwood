package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Location;
import com.revature.repositories.LocationRepository;

/**
 * Implementation of the LocationService interface.
 * Implements CRUD operations via JpaRepository.
 * @author Small
 *
 */
@Service
public class LocationServiceImpl implements LocationService {

	/**
	 * The repository used here.
	 */
	@Autowired
	LocationRepository locaRepo;
	/**
	 * Returns a list of all Locations.
	 */
	@Override
	public List<Location> findAllLocations() {
		return locaRepo.findAll();
	}
	/**
	 * Returns one Location object by an id.
	 */
	@Override
	public Location findLocationById(int id) {
		return locaRepo.getOne(id);
	}
	/**
	 * Saves a new Location object.
	 */
	@Override
	public Location addLocation(Location newLocation) {
		return locaRepo.save(newLocation);
	}
	/**
	 * Updates a single Location object.
	 */
	@Override
	public Location updateLocation(Location location) {
		return locaRepo.save(location);
	}
	/**
	 * Deletes a single Location object.
	 */
	@Override
	public Location deleteLocation(Location location) {
		locaRepo.delete(location);
		return location;
	}

}

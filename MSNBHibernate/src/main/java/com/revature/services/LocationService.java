package com.revature.services;

import java.util.List;

import com.revature.models.Location;

public interface LocationService {
	public List<Location> findAllLocations();
	public Location findLocationById(int id);
	public Location addLocation(Location newLocation);
	public Location updateLocation(Location location);
	public Location deleteLocation(Location location);
}

package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Preference;
import com.revature.models.PreferenceId;
import com.revature.repositories.PreferenceRepository;
/**
 * Implements the PreferenceService Interface.
 * Implements CRUD operations via JpaRepository.
 * @author Small
 *
 */
@Service
public class PreferenceServiceImpl implements PreferenceService {
	/**
	 * The used JpaRepository.
	 */
	@Autowired
	PreferenceRepository prefRepo;
	/**
	 * Returns a List of all Preferences in the Database.
	 */
	@Override
	public List<Preference> findAllPreferences() {
		return prefRepo.findAll();
	}
	/**
	 * Returns a Preference based on the composite id provided.
	 */
	@Override
	public Preference findPreferenceByKey(PreferenceId pId) {
		return prefRepo.getOne(pId);
	}
	/**
	 * Adds a Preference to the Database.
	 */
	@Override
	public Preference addPreference(Preference newPreference) {
		return prefRepo.save(newPreference);
	}
	/**
	 * Updates a preference in the database.
	 */
	@Override
	public Preference updatePreference(Preference preference) {
		return prefRepo.save(preference);
	}
	/**
	 * Deletes a given preference from a database.
	 */
	@Override
	public Preference deletePreference(Preference preference) {
		prefRepo.delete(preference);
		return preference;
	}
	/**
	 * Gets a list of preferences that have a common genre.
	 */
	@Override
	public List<Preference> findPreferencesByGenre(String genre){
		return prefRepo.findPreferencesByGenre(genre);
	}
	/**
	 * Deletes a preference given it's composite id.
	 */
	@Override
	public void deletePreferenceByPId(PreferenceId pId) {
		prefRepo.deleteById(pId);
		
	}

}

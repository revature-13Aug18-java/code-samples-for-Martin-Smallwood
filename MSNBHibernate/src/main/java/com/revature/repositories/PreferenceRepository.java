package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Preference;
import com.revature.models.PreferenceId;

/**
 * JpaRepository for Preference Object.
 * @author Small
 *
 */
@Repository
public interface PreferenceRepository extends JpaRepository<Preference,PreferenceId> {
	/**
	 * Finds a List of Preferences by Genre.
	 * Used in the logic to get a list of users by genre.
	 * @param genre
	 * @return
	 */
	public List<Preference> findPreferencesByGenre(String genre);
}

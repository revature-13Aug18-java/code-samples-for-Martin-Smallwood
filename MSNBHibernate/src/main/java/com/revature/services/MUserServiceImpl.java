package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.MUser;
import com.revature.models.Preference;
import com.revature.repositories.MUserRepository;
import com.revature.repositories.PreferenceRepository;

/**
 * Implementation of the MUserService interface.
 * Implements CRUD operations via JpaRepository.
 * @author Small
 *
 */
@Service
public class MUserServiceImpl implements MUserService {
	/**
	 * JpaRepository used here.
	 */
	@Autowired
	MUserRepository mUserRepo;
	
	/**
	 * Used for matching method.
	 */
	@Autowired
	PreferenceRepository prefRepo;
	
	/**
	 * Finds all users in the Database.
	 */
	@Override
	public List<MUser> findAllMUsers() {
		return mUserRepo.findAll();
	}
	/**
	 * Finds a single user by the id.
	 */
	@Override
	public MUser findMUserById(int id) {
		return mUserRepo.getOne(id);
	}
	/**
	 * Adds a new User.
	 */
	@Override
	public MUser addMUser(MUser newMUser) {
		return mUserRepo.save(newMUser);
	}
	/**
	 * Updates a single User.
	 */
	@Override
	public MUser updateMUser(MUser mUser) {
		return mUserRepo.save(mUser);
	}
	/**
	 * Deletes a single user.
	 */
	@Override
	public MUser deleteMUser(MUser mUser) {
		mUserRepo.delete(mUser);
		return mUser;
	}
	/**
	 * Finds a list of users based on a matching to their first names.
	 * Finds the users by their First name if their First name starts with
	 * the operand String, ignoring case.
	 */
	@Override
	public List<MUser> findByFirstName(String firstName) {
		return mUserRepo.findByFirstNameIgnoreCaseStartingWith(firstName);
	}
	/**
	 * Finds a user by Email and Password combination.
	 * Returns a null user if the password or email are incorrect.
	 */
	@Override
	public MUser login(String email, String password) {
		return mUserRepo.findMUserByEmailAndPassword(email, password);
	}
	/**
	 * Finds a List of Users by a common liked Genre.
	 * First finds a list of Preferences by searching it by genre.
	 * Second populates m with a user per each the userid inside of the pId.
	 * Lastly, returns m.
	 */
	@Override
	public List<MUser> findMUserByGenre(String gVar){
		List<MUser> m = new ArrayList<>();
		List<Preference> p = prefRepo.findPreferencesByGenre(gVar);
		
		for(Preference pref: p) {
			m.add(mUserRepo.getOne(pref.getpId().getmuser_id()));
		}
		return m;
	}
	/**
	 * Finds a user by their email.
	 */
	@Override
	public MUser findMUserByUsername(String email) {
		return mUserRepo.getMUserByEmail(email);
	}
	/**
	 * Matches two users by their preferences.
	 * If two users have a common preference, their preference levels for
	 * that genre are added to a score. Returns that score.
	 * Score ranges from 0 to 100.
	 */
	@Override
	public float matchTwoUsers(MUser one, MUser two) {
		float score = 0.0F;
		for(Preference p: one.getPrefs()) {
			for(Preference t: two.getPrefs()) {
				if(p.getGenre().equals(t.getGenre())) {
					score += (11-p.getpId().getpLevel())+(11-t.getpId().getpLevel());
				}
			}
		}
		return score/1.1F;
	}


}

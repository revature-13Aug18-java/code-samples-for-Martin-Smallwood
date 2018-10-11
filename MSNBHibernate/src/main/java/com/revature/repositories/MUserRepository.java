package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.MUser;

/**
 * JpaRepository for the MUser object.
 * @author Small
 *
 */
@Repository
public interface MUserRepository extends JpaRepository<MUser,Integer>{
	/**
	 * Finds a user by their email and password.
	 * Used for login verification.
	 * @param email
	 * @param password
	 * @return
	 */
	public MUser findMUserByEmailAndPassword(String email, String password);

	/**
	 * Finds a user by their email.
	 * @param email
	 * @return
	 */
	public MUser getMUserByEmail(String email);
	
	/**
	 * Finds a list of users based on if their first name starts with the string
	 * firstName.
	 * Used for user live-search.
	 * @param firstName
	 * @return
	 */
	public List<MUser> findByFirstNameIgnoreCaseStartingWith(String firstName);
}
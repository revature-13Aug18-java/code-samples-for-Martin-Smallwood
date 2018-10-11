package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Friend;

/**
 * JpaRepository for the Friend object.
 * @author Small
 *
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	/**
	 * Finds a List of Friends by person
	 * @param person refers to the first column in this table.
	 * @return
	 */
	public List<Friend> getFriendsByPerson(int person);
	/**
	 * Find a List of Friends by isFriendsWith
	 * @param isFriendsWith refers to the second column in this table.
	 * @return
	 */
	public List<Friend> getFriendsByIsFriendsWith(int isFriendsWith);
}

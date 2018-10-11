package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Friend;
import com.revature.repositories.FriendRepository;

/**
 * Implementation of the FriendService interface.
 * Implements CRUD operations based using an AutoWired JpaRepository.
 * @author Small
 *
 */
@Service
public class FriendServiceImpl implements FriendService {
	
	/**
	 * The autowired JpaRepository used here.
	 */
	@Autowired
	FriendRepository frieRepo;
	/**
	 * Finds all Friends in the Database and returns them as a List of Friends
	 */
	@Override
	public List<Friend> findAllFriends() {
		return frieRepo.findAll();
	}
	
	/**
	 * Finds a List of Friends by a common person.
	 */
	@Override
	public List<Friend> findFriendsByPerson(int person){
		return frieRepo.getFriendsByPerson(person);
	}
	
	/**
	 * Finds a list of friends by a common person they are friends with.
	 */
	@Override
	public List<Friend> findFriendsByIsFriendsWith(int isFriendsWith){
		return frieRepo.getFriendsByIsFriendsWith(isFriendsWith);
	}
	
	/**
	 * Finds one Friend object.
	 */
	@Override
	public Friend findFriendById(int id) {
		return frieRepo.getOne(id);
	}
	/**
	 * Adds one Friend object.
	 */
	@Override
	public Friend addFriend(Friend newFriend) {
		return frieRepo.save(newFriend);
	}
	/**
	 * Updates one Friend object.
	 */
	@Override
	public Friend updateFriend(Friend friend) {
		return frieRepo.save(friend);
	}
	/**
	 * Deletes one Friend object.
	 */
	@Override
	public Friend deleteFriend(Friend friend) {
		frieRepo.delete(friend);
		return friend;
	}

}

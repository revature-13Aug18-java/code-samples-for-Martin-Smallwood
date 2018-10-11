package com.revature.services;

import java.util.List;

import com.revature.models.Friend;

public interface FriendService {
	public List<Friend> findAllFriends();
	public Friend findFriendById(int id);
	public Friend addFriend(Friend newFriend);
	public Friend updateFriend(Friend friend);
	public Friend deleteFriend(Friend friend);
	List<Friend> findFriendsByPerson(int person);
	List<Friend> findFriendsByIsFriendsWith(int isFriendsWith);
}

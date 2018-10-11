package com.revature.services;

import java.util.List;

import com.revature.models.MUser;

public interface MUserService {
	public List<MUser> findAllMUsers();
	public MUser findMUserById(int id);
	public MUser addMUser(MUser newMUser);
	public MUser updateMUser(MUser mUser);
	public MUser deleteMUser(MUser mUser);
	public MUser login(String email, String password);
	public List<MUser> findMUserByGenre(String gVar);
	public MUser findMUserByUsername(String username);
	public float matchTwoUsers(MUser one, MUser two);
	public List<MUser> findByFirstName(String firstName);
}

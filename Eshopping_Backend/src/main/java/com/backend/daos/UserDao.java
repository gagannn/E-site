package com.backend.daos;

import java.util.List;

import com.backend.models.User;


public interface UserDao {
	public boolean registerUser(User userObj);
	public User validateUser(User u);
	public User getUser(String email);
}

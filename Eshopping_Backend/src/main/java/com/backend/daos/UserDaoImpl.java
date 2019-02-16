package com.backend.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.backend.models.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory SessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean registerUser(User userObj) {
		try {
			Session session=SessionFactory.getCurrentSession();
			userObj.setPassword(passwordEncoder.encode(userObj.getPassword()));
			session.save(userObj);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public User validateUser(User u) {
		Session session=SessionFactory.getCurrentSession();
		User obj=(User)session.get(User.class,u.getEmail());

		if(obj.getPassword().equals(u.getPassword()))
		{
			return obj;
		}

		return null;
	}

	@Override
	public User getUser(String email) {
		Session session=SessionFactory.getCurrentSession();
		User obj=(User)session.get(User.class,email);
		if(obj!=null)
			return obj;
		return null;
	}

}

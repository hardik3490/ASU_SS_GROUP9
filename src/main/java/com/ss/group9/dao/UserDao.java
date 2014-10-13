package com.ss.group9.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ss.group9.model.Role;
import com.ss.group9.model.User;

	
/**
 * 
 * User database operations will be supplied from this class
 * 
 * @author hardik
 * 
 */
@Repository
public class UserDao {

	public User loadUserByUsername(final String username) {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setUsername("user");
		user.setPassword("1111");
		Role r = new Role();
		r.setName("ROLE_ADMIN");
		List<Role> roles = new ArrayList<Role>();
		roles.add(r);
		user.setAuthorities(roles);
		return user;
	}

}

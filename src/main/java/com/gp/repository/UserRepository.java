package com.gp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.User;

public interface UserRepository extends CrudRepository<User,Integer>{

//	User findByName(String name);
	
	public List<User> findByUserName(String userName);
}

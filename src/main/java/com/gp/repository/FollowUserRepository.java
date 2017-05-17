package com.gp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.FollowUser;


public interface FollowUserRepository extends CrudRepository<FollowUser,Integer>{

	public List<FollowUser> findByUserId(int UserId);
}

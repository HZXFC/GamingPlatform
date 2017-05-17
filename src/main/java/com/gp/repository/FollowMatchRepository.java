package com.gp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.FollowMatch;

public interface FollowMatchRepository extends CrudRepository<FollowMatch,Integer>{

	public List<FollowMatch> findByUserId(int UserId);
	
}

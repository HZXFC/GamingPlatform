package com.gp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.FollowUser;
import com.gp.repository.FollowUserRepository;

@Service
public class FollowUserService {

	@Resource
	private FollowUserRepository followUserRepository;
	
	@Transactional
	public FollowUser save(FollowUser followUser){
		return followUserRepository.save(followUser);
	}
	
	@Transactional
	public List<FollowUser> findByUserId(int UserId){
		return followUserRepository.findByUserId(UserId);
	}
	
	
}

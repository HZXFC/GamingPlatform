package com.gp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.FollowMatch;
import com.gp.repository.FollowMatchRepository;

@Service
public class FollowMatchService {

	@Resource
	private FollowMatchRepository followMatchRepository;
	
	@Transactional
	public FollowMatch save(FollowMatch followMatch){
		return followMatchRepository.save(followMatch);
	}
	
	@Transactional
	public List<FollowMatch> findByUserId(int userId){
		return followMatchRepository.findByUserId(userId);
	}
}

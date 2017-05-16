package com.gp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.RegistGroup;
import com.gp.repository.RegistGroupRepository;

@Service
public class RegistGroupService {

	@Resource
	private RegistGroupRepository registGroupRepository;
	
	@Transactional
	public RegistGroup save(RegistGroup registGroup){
		return registGroupRepository.save(registGroup);
	}
	
	@Transactional
	public RegistGroup findById(int id){
		return registGroupRepository.findOne(id);
	}
	
}

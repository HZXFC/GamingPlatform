package com.gp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.User;
import com.gp.repository.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository userRepository;
	
	@Transactional
    public User save(User user){
      return userRepository.save(user);      
    }

	@Transactional
	public List<User> finaByUserName(String userName){
		return userRepository.findByUserName(userName);
	}
	
	@Transactional
	public User findById(int Id){
		return userRepository.findOne(Id);
	}
	
	@Transactional
	public List<User> finaAll(){
	return  (List<User>) userRepository.findAll();
	}
}

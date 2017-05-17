package com.gp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.FollowUser;
import com.gp.bean.User;
import com.gp.service.FollowUserService;
import com.gp.service.UserService;

@RestController
@RequestMapping("/follow")
public class FollowUserController {

	@Resource
	private FollowUserService followUserService ;
	
	 @Resource
	 private UserService userService;
	 
	 @RequestMapping("/save")
	 public int save(int userId,int followedUserId){
		 FollowUser followUser = new FollowUser();
		 followUser.setUserId(userId);
		 followUser.setFollowedUserId(followedUserId);
		 followUserService.save(followUser);
		 return 1;
	 }
	 
	 @RequestMapping("/followList")
	 public List<User> findFollowList(int userId){
		 List<FollowUser> followUserList = followUserService.findByUserId(userId);
		 List<User> userList = new ArrayList<>();
		 for(FollowUser followUser:followUserList){
			 User u = new User();
			 u=userService.findById(followUser.getFollowedUserId());
			 userList.add(u);
		 }
		 
		 return userList;
		 
	 }
	 
	 
	 
	 boolean ifMutualFollow(FollowUser followUser){
			 List<FollowUser> followdUserList = followUserService.findByUserId(followUser.getFollowedUserId());
			 for(FollowUser followdUser:followdUserList){
				if(followdUser.getFollowedUserId()==followUser.getUserId()){
					return true;
				}
			 }
		 return false;
	 }
	 
	 @RequestMapping("/mutualFollowList")
	 public List<User> findMutualFollowList(int userId){
		 List<FollowUser> followUserList = followUserService.findByUserId(userId);
		 List<User> userList = new ArrayList<>();
		 for(FollowUser followUser:followUserList){
			 if(ifMutualFollow(followUser)){
			 User u = new User();
			 u=userService.findById(followUser.getFollowedUserId());
			 userList.add(u);
			 }
		 }
		 
		 return userList;
		 
	 }
	 
	 @RequestMapping("/ifFollowedByMe")
	 public int ifFollowedByMe(int userId,int followedUserId){
		 List<FollowUser> followUserList = followUserService.findByUserId(userId);
		 for(FollowUser followUser:followUserList){
			 if(followUser.getFollowedUserId()==followedUserId){
				 return 1;
			 }
		 }
		 return 0;
	 }
}

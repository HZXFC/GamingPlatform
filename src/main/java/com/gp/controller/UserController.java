package com.gp.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.User;
import com.gp.bean.UserDetail;
import com.gp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	 @Resource
	 private UserService userService;
	 
	 @RequestMapping("/save")
	 public String save(){
	       User user = new User();
	       user.setUserName("Angel");
	       user.setPassword("123456");
	       UserDetail ud = new UserDetail();
	       //ud.setUser(user);
	       ud.setAdmName("方成龙");
	       ud.setUserImg("/1.png");
	       user.setUser_detail(ud);
	       userService.save(user);//保存数据.
	       return "user save OK";
	    }
	 
	 @RequestMapping("/findByUserName")
	 public List<User> findByUserName(String userName){
		 return  userService.finaByUserName(userName);
	 }
	 
	 @RequestMapping("/findById")
	 public User findById(int id){
		 return userService.findById(id);
	 }
	 
	 @RequestMapping("/register")
	 public String register(String userName, String passWord){
		 List<User> userList = userService.finaByUserName(userName);
		 if(!userList.isEmpty()){
			 return "用户名已存在";
		 }else{
			 User user = new User();
			 user.setUserName(userName);
		     user.setPassword(passWord);
		     userService.save(user);
		     return "注册成功";
		 }
		 
	 }
	 
	 @RequestMapping("/login")
	 public String login(String userName, String passWord){
		 List<User> userList = userService.finaByUserName(userName);
		 if(userList.isEmpty()){
			 return "登录失败，用户名或密码错误";
		 }else{
			 for(User u :userList){
				 if(u.getPassword().equals(passWord)){
					 return "登陆成功";
				 } 
			 }
				 return "登录失败，用户名或密码错误";
			 }
		 }
}
	 


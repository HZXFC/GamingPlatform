package com.gp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.GameMatch;
import com.gp.bean.RegistGroup;
import com.gp.bean.User;
import com.gp.service.GameMatchService;
import com.gp.service.RegistGroupService;
import com.gp.service.UserService;

@RestController
@RequestMapping("/group")
public class RegistGroupController {

	@Resource
	private RegistGroupService registGroupService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private GameMatchService gameMatchService;
	
	
		@RequestMapping("/save")
		public String save(){
		RegistGroup rg = new RegistGroup();
		rg.setGroupName("奔波霸");
		
//		GameMatch gm = gameMatchService.findById(1);
//		rg.setGamematch(gm);
		
		User u = userService.findById(1);
		List<User> userList = new ArrayList<>();
		userList.add(u);
		rg.setUserList(userList);
		
		
		registGroupService.save(rg);
		
		return "save Ok";
	}
	
		@RequestMapping("/addGroup")
		public String addGroup(int matchId,int userId,String groupName){
			GameMatch gm = gameMatchService.findById(matchId);
			if(gm.getTeamNum() == gm.getGroupList().size()){
				
				return "创建队伍失败，比赛组数已到上限";
			}else if(ifRegisted(matchId,userId)){
				
				return "已经在比赛队伍中";
					
			}else{	
				User u = userService.findById(userId);
				RegistGroup g = new RegistGroup();
				List<User> userList = new ArrayList<>();
				userList.add(u);
				g.setGroupName(groupName);
				g.setUserList(userList);
				gm.addGroup(g);
				gameMatchService.save(gm);
				return "创建队伍成功";	
			}
				
		}
		
		@RequestMapping("/addGroupMember")
		public String addGroupMember(int matchId,int groupId,int userId){
				if(ifRegisted(matchId,userId)){
				
					return "已经在比赛队伍中";
					
				}else{
					GameMatch gm = gameMatchService.findById(matchId);
					RegistGroup g = registGroupService.findById(groupId);
					User u = userService.findById(userId);
					if(gm.getPersonNum()==g.getUserList().size()){
						return "加入队伍失败，队伍人数已到上限";
					}else{
						g.addUser(u);
						registGroupService.save(g);
						return "加入队伍成功";
					}
					
				}
		}
		
		
		
		@RequestMapping("/ifRegisted")
		public boolean ifRegisted(int matchId,int userId){
			GameMatch gm = gameMatchService.findById(matchId);
			List<RegistGroup> groupList = gm.getGroupList();
			for(RegistGroup g : groupList){
				List<User> userlist = g.getUserList();
				for(User u : userlist){
					if(u.getId()==userId){
						return true;
					}
				}
			}
			
			
			return false;
		}
	
}

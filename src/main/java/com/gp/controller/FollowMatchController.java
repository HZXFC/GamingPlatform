package com.gp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.FollowMatch;
import com.gp.bean.GameMatch;
import com.gp.service.FollowMatchService;
import com.gp.service.GameMatchService;
import com.gp.service.NewsService;

@RestController
@RequestMapping("/followMatch")
public class FollowMatchController {
	
	@Resource
	private FollowMatchService followMatchService;
	
	@Resource
	private GameMatchService gameMatchService;
	
	@Resource
	private NewsService newsService;
	
	 @RequestMapping("/save")
	 public int save(int userId,int matchId){
		 FollowMatch followMatch = new FollowMatch();
		 followMatch.setUserId(userId);
		 followMatch.setMatchId(matchId);
		 followMatchService.save(followMatch);
		 return 1; 
	 }
	
	 @RequestMapping("/followMatchList")
	 public List<GameMatch> followMatchList(int userId){
		 List<FollowMatch> followMatchList = followMatchService.findByUserId(userId);
		 List<GameMatch> gameMatchList =new ArrayList<>();
		for(FollowMatch floolwMatch:followMatchList)	{
			GameMatch gameMatch = new GameMatch();
			gameMatch=gameMatchService.findById(floolwMatch.getMatchId());
			gameMatchList.add(gameMatch);
			
		}
		 return gameMatchList;
	 }
	 
	 @RequestMapping("/ifFollowedByMe")
	 public int ifFollowedByMe(int userId,int matchId){
		 List<FollowMatch> followMatchList = followMatchService.findByUserId(userId);
		 for(FollowMatch floolwMatch:followMatchList)	{
			 if(floolwMatch.getMatchId()==matchId){
				 return 1;
			 }
		 }
		 return 0;
	 }
	 
}

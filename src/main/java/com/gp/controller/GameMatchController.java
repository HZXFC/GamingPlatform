package com.gp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.Comment;
import com.gp.bean.GameMatch;
import com.gp.bean.RegistGroup;
import com.gp.bean.User;
import com.gp.service.CommentService;
import com.gp.service.GameMatchService;
import com.gp.service.RegistGroupService;
import com.gp.service.UserService;

@RestController
@RequestMapping("/match")
public class GameMatchController {

	@Resource
	private GameMatchService gameMatchService;
	
	@Resource
	private CommentService commentService;
	

	
	@RequestMapping("/save")
	public int save(int award,String area,String deadline,String gameName,String matchIMG,String matchName,int ruleID,int personNum,int teamNum,String startTime) {
//		GameMatch gameMatch = new GameMatch();
//		@SuppressWarnings("deprecation")
//		Date d = new Date(deadline);
//		Date sd = new Date(startTime);
//		gameMatch.setArea(area);
//		gameMatch.setAward(award);
//		gameMatch.setDeadline(d);
//		gameMatch.setGameName(gameName);
//		gameMatch.setMatchIMG(matchIMG);
//		gameMatch.setMatchName(matchName);
//		gameMatch.setPersonNum(personNum);
//		gameMatch.setRuleID(ruleID);
//		gameMatch.setStartTime(sd);
//		gameMatch.setTeamNum(teamNum);
//		gameMatchService.save(gameMatch);
		
		return 1;
	}
	
	@RequestMapping("/findByGameName")
	public List<GameMatch> findByGameName(String gameName){
		return gameMatchService.findByGameName(gameName);
	}
	
	@RequestMapping("/findById")
	public GameMatch findById(int id){
		return gameMatchService.findById(id);
	}
	

}

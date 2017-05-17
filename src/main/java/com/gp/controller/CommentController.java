package com.gp.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.bean.Comment;
import com.gp.bean.GameMatch;
import com.gp.bean.User;
import com.gp.service.CommentService;
import com.gp.service.GameMatchService;
import com.gp.service.UserService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private GameMatchService gameMatchService;
	
	@Resource
	private CommentService commentService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/save")
	public int save(int gameId,int userId){
		GameMatch gm = gameMatchService.findById(gameId);
		User u = userService.findById(userId);
		Comment c = new Comment();
		c.setContent("这个比赛太好啦！");
		c.setDate(new Date());
		//c.setGamematch(gm);
		c.setUser(u);
		commentService.save(c);
		return 1;
	}
	
	@RequestMapping("/addComment")
	public int addComment(int matchId,int userId,String content){
		GameMatch gm = gameMatchService.findById(matchId);
		User u = userService.findById(userId);
		Comment c = new Comment();
		c.setDate(new Date());
		c.setUser(u);
		c.setContent(content);
		gm.addComment(c);
		gameMatchService.save(gm);
		return 1;
	}
	
	
}

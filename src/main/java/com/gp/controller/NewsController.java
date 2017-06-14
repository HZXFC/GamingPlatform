package com.gp.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gp.bean.News;
import com.gp.bean.User;
import com.gp.service.NewsService;

@RestController
@RequestMapping("/service")
public class NewsController {

	@Resource
	private NewsService newsService;
	
	@RequestMapping("/save")
	public int save(User user,String content){
		News n = new News();
		n.setUser(user);
		n.setContent(content);
		newsService.save(n);
		return 1;
	}
}

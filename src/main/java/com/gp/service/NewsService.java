package com.gp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.News;
import com.gp.repository.NewsRepository;

@Service
public class NewsService {

	@Resource
	private NewsRepository newsRepository;
	
	@Transactional
	public News save(News news){
		return newsRepository.save(news);
	}
	
}

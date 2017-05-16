package com.gp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.Comment;
import com.gp.repository.CommentRepository;

@Service
public class CommentService {

	@Resource
	private CommentRepository commentRepository;
	
	@Transactional
	public Comment save(Comment comment){
		return commentRepository.save(comment);
	}
	
	
}

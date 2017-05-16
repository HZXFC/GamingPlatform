package com.gp.repository;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer>{
	
}

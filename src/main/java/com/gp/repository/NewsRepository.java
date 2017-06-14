package com.gp.repository;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.News;

public interface NewsRepository extends CrudRepository<News,Integer>{

}

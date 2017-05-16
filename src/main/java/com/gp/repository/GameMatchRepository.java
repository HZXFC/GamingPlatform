package com.gp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gp.bean.GameMatch;

public interface GameMatchRepository extends CrudRepository <GameMatch,Integer>{

	public List<GameMatch> findByGameName (String gameName);
	
	
}

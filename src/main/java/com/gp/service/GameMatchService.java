package com.gp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.bean.GameMatch;
import com.gp.repository.GameMatchRepository;

@Service
public class GameMatchService {

	@Resource
	private GameMatchRepository gameMatchRepository;
	
	@Transactional
	public GameMatch save(GameMatch gameMatch){
		return gameMatchRepository.save(gameMatch);
	}

	
	@Transactional
	public List<GameMatch> findByGameName(String gameName){
		return gameMatchRepository.findByGameName(gameName);
	}
	
	@Transactional
	public GameMatch findById(int id){
		return gameMatchRepository.findOne(id);
	}
	
	
	
}

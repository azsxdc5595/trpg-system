package com.example.trpg.web.game.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.trpg.dao.mapper.customize.MapTitleCustomizeMapper;
import com.example.trpg.dao.model.MapTitle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

	private final MapTitleCustomizeMapper mapTitleCustomizeMapper;
    public Map<String, MapTitle> newGame() {
    	Map<String, MapTitle> dataMap = new HashMap<>();
    	dataMap.put("startMapTitle", mapTitleCustomizeMapper.getStartMapTitle());
        return dataMap;
    }
	public MapTitle draw() {
		// TODO Auto-generated method stub
		return null;
	}
}

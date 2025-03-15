package com.example.trpg.web.game.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.trpg.Service.SnowflakeService;
import com.example.trpg.dao.mapper.MapTitleMapper;
import com.example.trpg.dao.mapper.TempGameMapTitleMapper;
import com.example.trpg.dao.mapper.customize.MapTitleCustomizeMapper;
import com.example.trpg.dao.mapper.customize.TempGameMapTitleCustomizeMapper;
import com.example.trpg.dao.model.MapTitle;
import com.example.trpg.dao.model.TempGameMapTitle;
import com.example.trpg.web.game.TempGameMapTitleE;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

	private final MapTitleMapper mapTitleMapper;
	private final MapTitleCustomizeMapper mapTitleCustomizeMapper;
	private final TempGameMapTitleMapper tempGameMapTitleMapper;
	private final TempGameMapTitleCustomizeMapper tempGameMapTitleCustomizeMapper;
	private final SnowflakeService snowflakeService;
	
    public Map<String, Object> newGame() {
    	Map<String, Object> dataMap = new HashMap<>();
    	String snowNo = snowflakeService.getSnowNo();
    	dataMap.put("snowNo", snowNo);
    	MapTitle mapTitle = mapTitleCustomizeMapper.getStartMapTitle();
    	TempGameMapTitle tgMapTitle = TempGameMapTitle.builder().uid(snowNo).mapTitleId(mapTitle.getId()).relatedEvents("1350354939390726144").x(0).y(0).floor(0).build();
    	tempGameMapTitleMapper.insert(tgMapTitle);
		return dataMap;
    	
    }

	public Map<String, Object> query() {
		Map<String, Object> dataMap = new HashMap<>();
		List<TempGameMapTitleE> listE = new ArrayList<>();
		List<TempGameMapTitle> list = tempGameMapTitleCustomizeMapper.list();
		for (TempGameMapTitle tgMapTitle : list) {
			MapTitle mapTitle = mapTitleMapper.selectByPrimaryKey(tgMapTitle.getMapTitleId());
			String icon = mapTitle.getIcon();
			TempGameMapTitleE tempGameMapTitleE = TempGameMapTitleE.builder().x(tgMapTitle.getX()).y(tgMapTitle.getY()).floor(tgMapTitle.getFloor()).relatedEvents(tgMapTitle.getRelatedEvents()).icon(icon).build();
			listE.add(tempGameMapTitleE);
		}
		dataMap.put("tempGameMapTitle", listE);
		return dataMap;
	}
	
	public Map<String, String> drawTile() {
		Map<String, String> dataMap = new HashMap<>();
		MapTitle mapTitle = mapTitleCustomizeMapper.getRandomEnabledTile();
		dataMap.put("name", mapTitle.getName());
		dataMap.put("icon", mapTitle.getIcon());
        return dataMap;
	}
}

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
import com.example.trpg.web.game.domain.TempGameMapTitleCheck;
import com.example.trpg.web.game.domain.TempGameMapTitleE;

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
    	TempGameMapTitle tgMapTitle = TempGameMapTitle.builder().uid(snowNo).mapTitleId(mapTitle.getId()).relatedEvents("1350354939390726144").x(0).y(0).floor(1).build();
    	tempGameMapTitleMapper.insert(tgMapTitle);
		return dataMap;
    	
    }

	public Map<String, Object> query(String snowNo) {
		Map<String, Object> dataMap = new HashMap<>();
		List<TempGameMapTitleE> listE = new ArrayList<>();
		List<TempGameMapTitle> list = tempGameMapTitleCustomizeMapper.list(snowNo);
		for (TempGameMapTitle tgMapTitle : list) {
			MapTitle mapTitle = mapTitleMapper.selectByPrimaryKey(tgMapTitle.getMapTitleId());
			String icon = mapTitle.getIcon();
			TempGameMapTitleE tempGameMapTitleE = TempGameMapTitleE.builder().x(tgMapTitle.getX()).y(tgMapTitle.getY()).floor(tgMapTitle.getFloor()).relatedEvents(tgMapTitle.getRelatedEvents()).icon(icon).build();
			listE.add(tempGameMapTitleE);
		}
		dataMap.put("tempGameMapTitle", listE);
		return dataMap;
	}
	
	public Map<String, Object> drawTile() {
		Map<String, Object> dataMap = new HashMap<>();
		MapTitle mapTitle = mapTitleCustomizeMapper.getRandomEnabledTile();
		dataMap.put("id", mapTitle.getId());
		dataMap.put("icon", mapTitle.getIcon());
        return dataMap;
	}

	public String check(TempGameMapTitleCheck tempGameMapTitleCheck) {
		String message = "";
		String snowNo = tempGameMapTitleCheck.getSnowNo();
		Integer x = tempGameMapTitleCheck.getX();
		Integer y = tempGameMapTitleCheck.getY();
		Integer floor = tempGameMapTitleCheck.getFloor();
		MapTitle mapTitle = mapTitleCustomizeMapper.getPatternByIcon(tempGameMapTitleCheck.getIcon());
		String newPattern = mapTitle.getPattern();
		boolean canPlace = false;
		//檢查要放的那格，周圍是否有可以連結的板塊
		List<TempGameMapTitle> list = tempGameMapTitleCustomizeMapper.list(snowNo);
		for (TempGameMapTitle tgMapTitle : list) {
			int existX = tgMapTitle.getX();
	        int existY = tgMapTitle.getY();
	        int existFloor = tgMapTitle.getFloor();
	        String pattern = mapTitleMapper.selectByPrimaryKey(tgMapTitle.getMapTitleId()).getPattern(); // 已存在的板塊方向
	        
	        // 確認是否可以連結
	        if (existX + 1 == x && existY == y && pattern.charAt(5) == '1' && newPattern.charAt(3) == '1' && floor == existFloor) {
	            canPlace = true; // 右邊板塊能連結
	            break;
	        }
	        if (existX - 1 == x && existY == y && pattern.charAt(3) == '1' && newPattern.charAt(5) == '1' && floor == existFloor) {
	            canPlace = true; // 左邊板塊能連結
	            break;
	        }
	        if (existX == x && existY + 1 == y && pattern.charAt(7) == '1' && newPattern.charAt(1) == '1' && floor == existFloor) {
	            canPlace = true; // 下方板塊能連結
	            break;
	        }
	        if (existX == x && existY - 1 == y && pattern.charAt(1) == '1' && newPattern.charAt(7) == '1' && floor == existFloor) {
	            canPlace = true; // 上方板塊能連結
	            break;
	        }
		}
		if (!canPlace) {
			message = "此格無法放置!請重新選擇";
		}
		return message;
	}

	public String confirm(TempGameMapTitleCheck tempGameMapTitleCheck) {
		TempGameMapTitle tgMapTitle = TempGameMapTitle.builder().uid(tempGameMapTitleCheck.getSnowNo()).mapTitleId(tempGameMapTitleCheck.getId()).x(tempGameMapTitleCheck.getX()).y(tempGameMapTitleCheck.getY()).floor(tempGameMapTitleCheck.getFloor()).relatedEvents("").build();
    	tempGameMapTitleMapper.insertSelective(tgMapTitle);
		return "成功放置板塊!";
	}
}

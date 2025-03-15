package com.example.trpg.web.game.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.web.game.domain.TempGameMapTitleCheck;
import com.example.trpg.web.game.service.GameService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;
	
    @GetMapping("/newGame")
    public ModelAndView init() {
        return new ModelAndView("/game/game_model", gameService.newGame());
    }
    
	@PostMapping("/query") // 確保這裡是 POST
	public ResponseEntity<Map<String, Object>> query(String snowNo) {
		Map<String, Object> dataMap = gameService.query(snowNo);
		return ResponseEntity.ok(dataMap);
	}
	
	@PostMapping("/drawTile") // 確保這裡是 POST
	public ResponseEntity<Map<String, Object>> drawTile() {
		Map<String, Object> dataMap = gameService.drawTile();
		return ResponseEntity.ok(dataMap);
	}
	
	@PostMapping("/check") // 確保這裡是 POST
	public ResponseEntity<String> check(TempGameMapTitleCheck tempGameMapTitleCheck) {
		String message = gameService.check(tempGameMapTitleCheck);
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/confirm") // 確保這裡是 POST
	public ResponseEntity<String> confirm(TempGameMapTitleCheck tempGameMapTitleCheck) {
		String message = gameService.confirm(tempGameMapTitleCheck);
		return ResponseEntity.ok(message);
	}
}

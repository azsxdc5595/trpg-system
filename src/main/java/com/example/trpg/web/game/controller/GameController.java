package com.example.trpg.web.game.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ResponseEntity<Map<String, Object>> query() {
		Map<String, Object> dataMap = gameService.query();
		return ResponseEntity.ok(dataMap);
	}
	
	@PostMapping("/drawTile") // 確保這裡是 POST
	public ResponseEntity<Map<String, String>> drawTile() {
		Map<String, String> dataMap = gameService.drawTile();
		return ResponseEntity.ok(dataMap);
	}
}

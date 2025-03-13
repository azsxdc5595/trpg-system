package com.example.trpg.web.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.MapTitle;
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
    
    @PostMapping("/draw")
    public MapTitle draw() {
    	MapTitle mapTitle = gameService.draw();
        return mapTitle;
    }
}

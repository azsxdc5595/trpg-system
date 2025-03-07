package com.example.trpg.web.player.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.Player;
import com.example.trpg.web.player.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/player/player_list");

        // 呼叫 Service 層來取得分頁資料
        Page<Player> players = playerService.getPlayersByPage(page, pageSize);

        modelAndView.addObject("players", players.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", players.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getPlayersByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/player/player_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<Player> players = playerService.getPlayersByPage(page, pageSize);

            modelAndView.addObject("players", players.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", players.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createPlayerForm() {
        return new ModelAndView("/player/player_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePlayer(Player player) {
        playerService.save(player);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editPlayer(String uid) {
        ModelAndView modelAndView = new ModelAndView("/player/player_edit");
        modelAndView.addObject("player", playerService.toEdit(uid));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editPlayer(Player player) {
        playerService.edit(player);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePlayer(String uid) {
        playerService.delete(uid);
        return ResponseEntity.ok("刪除成功");
    }
}

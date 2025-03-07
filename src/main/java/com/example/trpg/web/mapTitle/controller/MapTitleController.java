package com.example.trpg.web.mapTitle.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.MapTitle;
import com.example.trpg.web.mapTitle.service.MapTitleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mapTitle")
@RequiredArgsConstructor
public class MapTitleController {

    private final MapTitleService mapTitleService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/mapTitle/mapTitle_list");

        // 呼叫 Service 層來取得分頁資料
        Page<MapTitle> mapTitles = mapTitleService.getMapTitlesByPage(page, pageSize);

        modelAndView.addObject("mapTitles", mapTitles.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", mapTitles.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getMapTitlesByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/mapTitle/mapTitle_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<MapTitle> mapTitles = mapTitleService.getMapTitlesByPage(page, pageSize);

            modelAndView.addObject("mapTitles", mapTitles.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", mapTitles.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createMapTitleForm() {
        return new ModelAndView("/mapTitle/mapTitle_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMapTitle(MapTitle mapTitle) {
        mapTitleService.save(mapTitle);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editMapTitle(int id) {
        ModelAndView modelAndView = new ModelAndView("/mapTitle/mapTitle_edit");
        modelAndView.addObject("mapTitle", mapTitleService.toEdit(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editMapTitle(MapTitle mapTitle) {
        mapTitleService.edit(mapTitle);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteMapTitle(int id) {
        mapTitleService.delete(id);
        return ResponseEntity.ok("刪除成功");
    }
}

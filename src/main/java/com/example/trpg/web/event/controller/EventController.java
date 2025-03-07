package com.example.trpg.web.event.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.Event;
import com.example.trpg.web.event.service.EventService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/event/event_list");

        // 呼叫 Service 層來取得分頁資料
        Page<Event> events = eventService.getEventsByPage(page, pageSize);

        modelAndView.addObject("events", events.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", events.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getEventsByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/event/event_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<Event> events = eventService.getEventsByPage(page, pageSize);

            modelAndView.addObject("events", events.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", events.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createEventForm() {
        return new ModelAndView("/event/event_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEvent(Event event) {
        eventService.save(event);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editEvent(String uid) {
        ModelAndView modelAndView = new ModelAndView("/event/event_edit");
        modelAndView.addObject("event", eventService.toEdit(uid));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editEvent(Event event) {
        eventService.edit(event);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEvent(String uid) {
        eventService.delete(uid);
        return ResponseEntity.ok("刪除成功");
    }
}

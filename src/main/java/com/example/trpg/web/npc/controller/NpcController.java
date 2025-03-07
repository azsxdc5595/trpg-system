package com.example.trpg.web.npc.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.Npc;
import com.example.trpg.web.npc.service.NpcService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/npc")
@RequiredArgsConstructor
public class NpcController {

    private final NpcService npcService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/npc/npc_list");

        // 呼叫 Service 層來取得分頁資料
        Page<Npc> npcs = npcService.getNpcsByPage(page, pageSize);

        modelAndView.addObject("npcs", npcs.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", npcs.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getNpcsByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/npc/npc_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<Npc> npcs = npcService.getNpcsByPage(page, pageSize);

            modelAndView.addObject("npcs", npcs.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", npcs.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createNpcForm() {
        return new ModelAndView("/npc/npc_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveNpc(Npc npc) {
        npcService.save(npc);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editNpc(String uid) {
        ModelAndView modelAndView = new ModelAndView("/npc/npc_edit");
        modelAndView.addObject("npc", npcService.toEdit(uid));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editNpc(Npc npc) {
        npcService.edit(npc);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteNpc(String uid) {
        npcService.delete(uid);
        return ResponseEntity.ok("刪除成功");
    }
}

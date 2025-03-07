package com.example.trpg.web.systemCode.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.SystemCode;
import com.example.trpg.web.systemCode.service.SystemCodeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/systemCode")
@RequiredArgsConstructor
public class SystemCodeController {

    private final SystemCodeService systemCodeService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/systemCode/systemCode_list");

        // 呼叫 Service 層來取得分頁資料
        Page<SystemCode> systemCodes = systemCodeService.getSystemCodesByPage(page, pageSize);

        modelAndView.addObject("systemCodes", systemCodes.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", systemCodes.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getSystemCodesByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/systemCode/systemCode_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<SystemCode> systemCodes = systemCodeService.getSystemCodesByPage(page, pageSize);

            modelAndView.addObject("systemCodes", systemCodes.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", systemCodes.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createSystemCodeForm() {
        return new ModelAndView("/systemCode/systemCode_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveSystemCode(SystemCode systemCode) {
        systemCodeService.save(systemCode);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editSystemCode(int id) {
        ModelAndView modelAndView = new ModelAndView("/systemCode/systemCode_edit");
        modelAndView.addObject("systemCode", systemCodeService.toEdit(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editSystemCode(SystemCode systemCode) {
        systemCodeService.edit(systemCode);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteSystemCode(int id) {
        systemCodeService.delete(id);
        return ResponseEntity.ok("刪除成功");
    }
}

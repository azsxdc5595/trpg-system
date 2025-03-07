package com.example.trpg.web.item.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trpg.dao.model.Item;
import com.example.trpg.web.item.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public ModelAndView init() {
        int page = 1; // 預設頁面為 1
        int pageSize = 10; // 頁面大小
        ModelAndView modelAndView = new ModelAndView("/item/item_list");

        // 呼叫 Service 層來取得分頁資料
        Page<Item> items = itemService.getItemsByPage(page, pageSize);

        modelAndView.addObject("items", items.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", items.getTotalPages());
        return modelAndView;
    }

    @GetMapping("/query")
    public ModelAndView getItemsByPage(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") Integer pageSize) { // 使用 Integer 而非 int
        ModelAndView modelAndView = new ModelAndView("/item/item_list");

        try {
            // 呼叫 Service 層來取得分頁資料
            Page<Item> items = itemService.getItemsByPage(page, pageSize);

            modelAndView.addObject("items", items.getContent());
            modelAndView.addObject("currentPage", page);
            modelAndView.addObject("totalPages", items.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "出現錯誤，請稍後再試");
        }

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createItemForm() {
        return new ModelAndView("/item/item_form");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveItem(Item item) {
        itemService.save(item);
        return ResponseEntity.ok("保存成功");
    }

    @PostMapping("/toEdit")
    public ModelAndView editItem(String uid) {
        ModelAndView modelAndView = new ModelAndView("/item/item_edit");
        modelAndView.addObject("item", itemService.toEdit(uid));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editItem(Item item) {
        itemService.edit(item);
        return ResponseEntity.ok("編輯成功");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteItem(String uid) {
        itemService.delete(uid);
        return ResponseEntity.ok("刪除成功");
    }
}

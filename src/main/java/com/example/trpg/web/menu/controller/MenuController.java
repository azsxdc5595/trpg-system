package com.example.trpg.web.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MenuController {

    @GetMapping("/")
    public ModelAndView init() {
        return new ModelAndView("/menu/menu_list");
    }
}

package com.example.trpg.web.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/manage")
@RequiredArgsConstructor
public class ManageController {

    //private final ManageService manageService;

    @GetMapping("/")
    public ModelAndView init() {
        return new ModelAndView("/manage/manage_list");
    }

}

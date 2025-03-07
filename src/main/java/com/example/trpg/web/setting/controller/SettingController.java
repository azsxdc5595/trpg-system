package com.example.trpg.web.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/setting")
@RequiredArgsConstructor
public class SettingController {

    @GetMapping("/")
    public ModelAndView init() {
        return new ModelAndView("/setting/setting_list");
    }
}

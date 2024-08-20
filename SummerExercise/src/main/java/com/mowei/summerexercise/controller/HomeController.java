package com.secret.summerexercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "RWD/RWDExercise.html"; // 根據靜態文件的實際路徑來設置
    }
}

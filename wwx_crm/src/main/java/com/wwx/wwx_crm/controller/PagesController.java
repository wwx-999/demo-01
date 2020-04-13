package com.wwx.wwx_crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/403")
    public String un(){
        return "403";
    }
}

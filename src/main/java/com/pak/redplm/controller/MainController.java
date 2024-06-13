package com.pak.redplm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/user")
    public String user(){

        return "globalPAKForSupply";
    }

    @GetMapping("/admin")
    public String admin(){

        return "GlobalPAKForDebugging";
    }

    @GetMapping("/worker")
    public String worker(){

        return "globalPAKForAssembler";
    }

    @GetMapping("/login")
    public String login(){
        return "custom_login";
    }
}

package com.pak.redplm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "custom_login";
    }

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    /*  У одного пользователя, работающего *конструктором есть возможность зайти под ролью *сборщика
    Прописывается индивидуально, связано с отпусками, больничными и перераспределением человекочасов
    в случае горящих сроков */

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


}

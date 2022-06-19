package net.planotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/authForm")
    public String auth(){
        return "resetForm";
    }
}

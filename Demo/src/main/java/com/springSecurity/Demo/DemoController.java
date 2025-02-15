package com.springSecurity.Demo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("/developer")
    public String developer(){
        return "developer";
    }

    @GetMapping("/tester")
    public String tester(){
        return "tester";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    //logged in user details
    @GetMapping("/developer/{name}")
    public String name(@PathVariable String name){
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "hello "+ myUser.getUsername();
    }

    @PostMapping("/addAdmin")
    public String addAdmin(){
        return "dummy";
    }


}

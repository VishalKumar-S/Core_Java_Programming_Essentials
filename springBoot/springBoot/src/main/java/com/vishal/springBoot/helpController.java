package com.vishal.springBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helpController {

    @GetMapping(path = "/help")
    public String help(){
        return "Contact Vishal Kumar. S";
    }
}





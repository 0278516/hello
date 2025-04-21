package com.zs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/query")
public class TestController {


    @GetMapping(value = "/cust-no")
    public String getCustNo() {
        return "14256373839";
    }
}

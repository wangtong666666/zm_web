package cn.wt.springbootdemo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String  hello(){

        System.out.println("hello");

        return "hello world";
    }

}

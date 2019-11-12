package cn.wt.springbootdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("authc")
public class AuthController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}

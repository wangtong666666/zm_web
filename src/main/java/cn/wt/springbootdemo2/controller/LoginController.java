package cn.wt.springbootdemo2.controller;


import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("login")
    public ResultObject login(){

        return ReturnResult.success();
    }



}

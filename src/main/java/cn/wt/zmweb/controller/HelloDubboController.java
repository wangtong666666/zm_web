package cn.wt.zmweb.controller;


import cn.wt.zmapi.service.HelloDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDubboController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private HelloDubboService helloDubboService;

    @RequestMapping("/sayHelloDubbo")
    public String sayHelloDubbo(){
        return helloDubboService.sayHelloDubbo();
    }
}

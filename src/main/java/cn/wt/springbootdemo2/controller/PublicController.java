package cn.wt.springbootdemo2.controller;


import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pub")
public class PublicController {

    @RequestMapping("/need_login")
    @ResponseBody
    public ResultObject needLogin(){

        return ReturnResult.error(ResultEnum.ERROR_TOKEN);

    }

    @RequestMapping("/not_permit")
    @ResponseBody
    public ResultObject notPermit(){
        return ReturnResult.error(ResultEnum.ERROR_PERMIT);
    }

    @RequestMapping("/index")
    @ResponseBody
    public ResultObject index(){

        List<String> videoList = new ArrayList<>();
        videoList.add("Mysql零基础入门到实战 数据库教程");
        videoList.add("Redis高并发高可用集群百万级秒杀实战");
        videoList.add("Zookeeper+Dubbo视频教程 微服务教程分布式教程");
        videoList.add("2019年新版本RocketMQ4.X教程消息队列教程");
        videoList.add("微服务SpringCloud+Docker入门到高级实战");

        return ReturnResult.success(videoList);

    }



    @PostMapping("/login")
    @ResponseBody
    public ResultObject login(String userName,String password, HttpServletRequest request, HttpServletResponse response){

        Subject subject = SecurityUtils.getSubject();


        Map<String,Object> loginInfo = new HashMap<>();

        try {

            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                loginInfo.put("sessionId",subject.getSession().getId());
                return ReturnResult.success(loginInfo);
            }else{
                return ReturnResult.falied("未知");
            }
        } catch ( UnknownAccountException uae ) {
            return ReturnResult.falied("用户名不存在");
        } catch ( IncorrectCredentialsException ice ) {
            return ReturnResult.falied("密码错误");
        } catch ( LockedAccountException lae ) {
            return ReturnResult.falied("用户被锁定，不能登录");
        } catch (AuthenticationException ae ) {
            return ReturnResult.falied("严重的错误");
        }


    }



}

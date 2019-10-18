package cn.wt.springbootdemo2.controller;


import cn.wt.springbootdemo2.rabbitMQ.FanoutConfig;
import cn.wt.springbootdemo2.rabbitMQ.FanoutProducer;
import cn.wt.springbootdemo2.redis.RedisFactoryString;
import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pub")
public class PublicController {

    @Autowired
    private RedisFactoryString redisFactoryString;

    @Autowired
    private FanoutProducer fanoutProducer;


    @RequestMapping("/sendEmail")
    @ResponseBody
    public ResultObject sendEmail(){

        String memo = "helloRabbitMq"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        fanoutProducer.sendRabbitMQ(FanoutConfig.QUEUE_EMAIL,memo);

        return ReturnResult.success();

    }



    @RequestMapping("/logout")
    @ResponseBody
    public ResultObject logout(){

        String sessionId = (String) SecurityUtils.getSubject().getSession().getId();

        redisFactoryString.del("shiro:session:"+sessionId);

        SecurityUtils.getSubject().logout();
        return ReturnResult.success();
    }

    @RequestMapping("/not_permit")
    @ResponseBody
    public ResultObject notPermit(){
        return ReturnResult.error(ResultEnum.ERROR_PERMIT);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
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

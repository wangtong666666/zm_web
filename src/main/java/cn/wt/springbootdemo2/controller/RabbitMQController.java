package cn.wt.springbootdemo2.controller;


import cn.wt.springbootdemo2.rabbitMQ.FanoutConfig;
import cn.wt.springbootdemo2.rabbitMQ.FanoutProducer;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("pub")
public class RabbitMQController {

    @Autowired
    private FanoutProducer fanoutProducer;

    @RequestMapping("sendSMS")
    @ResponseBody
    public ResultObject sendSMS(String queue,String key,String content){

        fanoutProducer.sendExchengeMQ(queue,key,content);

        return ReturnResult.success();
    }




}

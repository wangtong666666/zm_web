package cn.wt.zmweb.controller;


import cn.wt.zmweb.rabbitMQ.FanoutProducer;
import cn.wt.zmweb.result.ResultObject;
import cn.wt.zmweb.result.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

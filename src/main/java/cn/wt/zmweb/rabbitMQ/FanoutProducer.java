package cn.wt.zmweb.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

     public void sendQueueMQ(String queue,String memo){
         System.out.println("队列名称："+queue+",消息： "+memo);
         rabbitTemplate.convertAndSend(queue,memo);
     }

    public void sendExchengeMQ(String exchenge,String key,String memo){
        System.out.println("交换机名称："+exchenge+",消息： "+memo);
        rabbitTemplate.convertAndSend(exchenge,key,memo);
    }

}

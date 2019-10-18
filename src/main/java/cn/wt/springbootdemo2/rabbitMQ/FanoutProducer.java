package cn.wt.springbootdemo2.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

     public void sendRabbitMQ(String queue,String memo){
         System.out.println("队列名称："+queue+",消息： "+memo);
         rabbitTemplate.convertAndSend(queue,memo);
     }

}

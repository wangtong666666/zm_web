package cn.wt.springbootdemo2.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues=FanoutConfig.QUEUE_EMAIL)
public class EmailConsumer {

    @RabbitHandler
    public void process(String memo){

        System.out.println("邮件消费内容："+memo);

    }
}

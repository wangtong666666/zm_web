package cn.wt.springbootdemo2.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues=FanoutConfig.QUEUE_EMAIL)
    public void processEmail(String content) {
        System.out.println("ReceiveEmail:"+content);
    }

    @RabbitListener(queues=FanoutConfig.QUEUE_SMS)
    public void processSMS(String content) {
        System.out.println("ReceiveSMS:"+content);
    }

    @RabbitListener(queues=TopicConfig.QUEUE_NAME1)
    public void processTopicName1(String content) {
        System.out.println("ReceiveName1:"+content);
    }

    @RabbitListener(queues=TopicConfig.QUEUE_NAME2)
    public void processTopicName2(String content) {
        System.out.println("ReceiveName2:"+content);
    }

    @RabbitListener(queues=DirectConfig.QUEUE_NAME1)
    public void processDirectName1(String content) {
        System.out.println("ReceiveName1:"+content);
    }

    @RabbitListener(queues=DirectConfig.QUEUE_NAME2)
    public void processDirectName2(String content) {
        System.out.println("ReceiveName2:"+content);
    }

}


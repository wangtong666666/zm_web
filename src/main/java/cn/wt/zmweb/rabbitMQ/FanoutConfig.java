package cn.wt.zmweb.rabbitMQ;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FanoutConfig {

    //邮件队列
    public static final String QUEUE_EMAIL = "fanout.queue.email2";

    //短信队列
    public static final String QUEUE_SMS = "fanout.queue.sms";

    //交换机名称
    public static final String EXCHANGE_NAME = "fanout.exchange";

    //定义邮件队列
    @Bean
    public Queue fanoutQueueEmail(){
        return new Queue(QUEUE_EMAIL);
    }

    //定义短信队列
    @Bean
    public Queue fanoutQueueSms(){
        return new Queue(QUEUE_SMS);
    }

    //定义交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME);
    }


    //将队列与交换机绑定
    @Bean
    public Binding bindingExchangeEmail(){
        return BindingBuilder.bind(fanoutQueueEmail()).to(fanoutExchange());
    }


    //将队列与交换机绑定
    @Bean
    public Binding bindingExchangeSms(){
        return BindingBuilder.bind(fanoutQueueSms()).to(fanoutExchange());
    }

}

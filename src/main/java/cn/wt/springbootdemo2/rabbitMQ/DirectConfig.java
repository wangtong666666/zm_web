package cn.wt.springbootdemo2.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    public static final String QUEUE_NAME1 = "direct.queue.name1";
    public static final String QUEUE_NAME2 = "direct.queue.name2";

    public static final String DIRECT_EXCHANGE_NAME = "direct.exchange";

    @Bean
    public Queue getDirectQueueName1(){
        return new Queue(QUEUE_NAME1);
    }
    @Bean
    public Queue getDirectQueueName2(){
        return new Queue(QUEUE_NAME2);
    }
    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }
    @Bean
    public Binding bindingDirectQueueName1(){
        return BindingBuilder.bind(getDirectQueueName1()).to(getDirectExchange()).with("direct_name1");
    }
    @Bean
    public Binding bindingDirectQueueName2(){
        return BindingBuilder.bind(getDirectQueueName2()).to(getDirectExchange()).with("direct_name2");
    }

}

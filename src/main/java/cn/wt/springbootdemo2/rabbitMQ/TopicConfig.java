package cn.wt.springbootdemo2.rabbitMQ;



import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    public static final String QUEUE_NAME1 = "topic.queue.name1";
    public static final String QUEUE_NAME2 = "topic.queue.name2";

    public static final String EXCHENGE_NAME = "topic.exchenge";

    @Bean
    public Queue getQueueName1(){
        return new Queue(QUEUE_NAME1);
    }
    @Bean
    public Queue getQueueName2(){
        return new Queue(QUEUE_NAME2);
    }
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(EXCHENGE_NAME);
    }

    @Bean
    public Binding bindingTopicQueueName1(){
        return BindingBuilder.bind(getQueueName1()).to(getTopicExchange()).with("topic.message");
    }
    @Bean
    public Binding bindingTopicQueueName2(){
        return BindingBuilder.bind(getQueueName2()).to(getTopicExchange()).with("topic.#");
    }

}

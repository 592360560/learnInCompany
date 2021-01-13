package cn.ztal.learn.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "Direct exchange";
    public static final String QUEUE_NAME1 = "first-queue";
    public static final String QUEUE_NAME2 = "second-queue";

//    @Autowired
//    RabbitAdmin rabbitAdmin;

//    @Bean
//    public DirectExchange exchange() { // 使用直连的模式
//        return new DirectExchange(EXCHANGE, true, false);
//    }
//    @Bean
//    public Binding bindingAueue() {
////        return BindingBuilder.bind(queueInsureAdd()).to(exchange()).with(ROUTINGKEY);
//        return BindingBuilder.bind(firstQueue()).to(this.exchange()).with("key fq-ex");
//    }

    @Bean("firstQueue")
    public Queue firstQueue(){
       return new Queue(QUEUE_NAME1,true,false,false,null);
    }

//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 只有设置为 true，spring 才会加载 RabbitAdmin 这个类
//        rabbitAdmin.setAutoStartup(true);
//        return rabbitAdmin;
//    }
//
//    //创建交换机和对列
//    @Bean
//    public void createExchangeQueue (){
//        rabbitAdmin.declareExchange(exchange());
//        rabbitAdmin.declareQueue(firstQueue());
//    }

}

package cn.ztal.learn.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "Direct-exchange";
    public static final String FANOUT_EXCHANGE = "Fanout_Exchange";
    public static final String QUEUE_NAME1 = "first-queue";
    public static final String FANOUT_QUEUE_NAME1 = "fanout_queue1";
    public static final String FANOUT_QUEUE_NAME2 = "fanout_queue2";

//    @Autowired
//    RabbitAdmin rabbitAdmin;

    @Bean
    public DirectExchange directExchange() {
        // 使用直连的模式
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Binding bindingAueue() {
        //根据key匹配的交换器是直连（direct）模式交换器
        return BindingBuilder.bind(firstQueue()).to(directExchange()).with("key fq-ex");
    }
    //1.简单模式、2.工作模式{交换器(直连交换器) 可要可不要  使用routingKey匹配队列}
    @Bean("firstQueue")
    public Queue firstQueue(){
       return new Queue(QUEUE_NAME1,true,false,false,null);
    }
    //2.发布/订阅模式 (一个路由 发送到不同的队列（不指定Routing Key）)
//    @Bean("fanoutQueue1")
//    public Queue fanoutQueue1(){
//        return new Queue(FANOUT_QUEUE_NAME1,true,false,true,null);
//    }




    // 使用发布/订阅（fanout）模式
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        // 使用发布/订阅（fanout）模式
//        return new FanoutExchange(FANOUT_EXCHANGE, true, false);
//    }
//    @Bean("fanoutQueue2")
//    public Queue fanoutQueue2(){
//        return new Queue(FANOUT_QUEUE_NAME2,true,false,true,null);
//    }
//    @Bean
//    public Binding fanoutQueue1Bind() {
//        //不需要key匹配的交换器是 发布/订阅（fanout）模式交换器
//        //绑定队列
//        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
//    }
//    @Bean
//    public Binding fanoutQueue2Bind() {
//        //不需要key匹配的交换器是 发布/订阅（fanout）模式交换器
//        //绑定队列
//        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
//    }



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

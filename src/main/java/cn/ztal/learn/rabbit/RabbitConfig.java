package cn.ztal.learn.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "ztal's exchange";
    public static final String QUEUE_NAME1 = "first-queue";
    public static final String QUEUE_NAME2 = "second-queue";


}

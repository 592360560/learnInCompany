package cn.ztal.learn.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqUtils {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sent(){
        rabbitTemplate.convertAndSend("ztal","ztal's message");
    }


}

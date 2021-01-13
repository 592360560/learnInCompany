package cn.ztal.learn.rabbit;

import cn.ztal.learn.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
    @RabbitListener(queues = "first-queue")
    public void processMessage(Message msg) {
        System.out.println("Consumer1 = " + msg.toString());
    }

}

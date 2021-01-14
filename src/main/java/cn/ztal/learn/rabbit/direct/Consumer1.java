package cn.ztal.learn.rabbit.direct;

//import cn.ztal.learn.model.Message;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer1 {
    @RabbitListener(queues = "first-queue")
    public void processMessage(Message msg, Channel channel) {
        System.out.println("Consumer1 = " + msg.getBody().toString());
        try {
            Thread.sleep(1000);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

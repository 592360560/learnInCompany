package cn.ztal.learn.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer2 {
    @RabbitListener(queues = "first-queue")
    public void processMessage(Message msg, Channel channel) {
        System.out.println("Consumer2 = " + msg.toString());
        try {
            Thread.sleep(3000);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),true);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

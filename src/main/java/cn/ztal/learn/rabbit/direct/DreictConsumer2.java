package cn.ztal.learn.rabbit.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class DreictConsumer2 {
    @RabbitListener(
            bindings = {@QueueBinding(
                    value = @Queue(name = "Direct_Queue2",autoDelete = "false",durable = "true"),
                    exchange = @Exchange(value = "Direct_Exchange"),key = {"error"})
            })
    public void processMessage(Message msg, Channel channel) {
        System.out.println("DreictConsumer2 = " + new String(msg.getBody()));
        try {
            Thread.sleep(1000);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

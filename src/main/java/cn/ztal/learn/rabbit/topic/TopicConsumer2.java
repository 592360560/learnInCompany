package cn.ztal.learn.rabbit.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicConsumer2 {
    @RabbitListener(
            bindings = {@QueueBinding(
                    value = @Queue(name = "Topic_Queue2",autoDelete = "false",durable = "true"),
                    exchange = @Exchange(value = "Topic_Exchange",type = "topic"),key = "*.count")
            })
    public void processMessage(Message msg, Channel channel) {
        System.out.println("TopicConsumer2 = " + new String(msg.getBody()));
        try {
            Thread.sleep(100);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

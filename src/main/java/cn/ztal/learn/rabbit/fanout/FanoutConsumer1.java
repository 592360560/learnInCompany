package cn.ztal.learn.rabbit.fanout;

//import cn.ztal.learn.model.Message;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FanoutConsumer1 {
//        @RabbitListener(queues = {"fanout_queue1","fanout_queue2"})
@RabbitListener(
        bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(value = "Fanout_Exchange",type = "fanout"))
        })
    public void processMessage(Message msg, Channel channel) {
        System.out.println("FanoutConsumer1 = " + new String(msg.getBody()));
        try {
            Thread.sleep(100);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

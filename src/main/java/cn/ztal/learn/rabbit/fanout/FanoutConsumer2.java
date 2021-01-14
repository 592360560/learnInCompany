package cn.ztal.learn.rabbit.fanout;

//import cn.ztal.learn.model.Message;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FanoutConsumer2 {
    @RabbitListener(queues = "fanout_queue2")
    public void processMessage(Message msg, Channel channel) {
        System.out.println("FanoutConsumer2 = " + msg.getBody().toString());
        try {
            Thread.sleep(1500);
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package cn.ztal.learn.rabbit;

import cn.ztal.learn.model.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Run {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitConfig rabbitConfig;
//    @Resource(name = "firstQueue")
//    private Queue firstQueue;

    public void sent(){
        Message m = new Message();
        m.setInfo("say something");
        m.setTitle("this is title");
        rabbitTemplate.convertAndSend("Direct exchange","key fq-ex",m);
    }
}

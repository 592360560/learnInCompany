package cn.ztal.learn;

import cn.ztal.learn.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
class LearnApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void sent() {
        Message m = new Message();
        m.setInfo("say test");
        m.setTitle("this is test title");
//        rabbitTemplate.convertAndSend("ztal",m);
        rabbitTemplate.convertAndSend("","test_key",m);
        System.out.println(m.toString());
    }
    @Test
    void contextLoads() {
    }

}

package cn.ztal.learn.rabbit;

import cn.ztal.learn.model.Message;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@ContextConfiguration(locations = "classpath:application.properties")
//@TestPropertySource("classpath:application.properties")
class RabbitMqUtilsTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void sent() {
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            m.setInfo("say something "+i);
            m.setTitle("this is title "+i);
            rabbitTemplate.convertAndSend("","first-queue",m);
        }
//        rabbitTemplate.convertAndSend("ztal","ztal's message");
    }

    @Test
    void read() {
//        Object o = rabbitTemplate.receiveAndConvert("first-queue");
//        Message m = (Message) o;
//        System.out.println(m.toString());

    }
}
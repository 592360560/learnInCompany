package cn.ztal.learn.rabbit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class RabbitMqUtilsTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void sent() {
        rabbitTemplate.convertAndSend("ztal","ztal's message");
    }
}
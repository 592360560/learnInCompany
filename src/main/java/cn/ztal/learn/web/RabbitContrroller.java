package cn.ztal.learn.web;

import cn.ztal.learn.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitContrroller {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sentWork")
    public String sent(String message){
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            if (message !=null){
                m.setInfo("say something "+i+message);
                m.setTitle("this is title "+i+message);
            }else {
                m.setInfo("say something "+i);
                m.setTitle("this is title "+i);
            }
            rabbitTemplate.convertAndSend("","first-queue",m.toString());
        }
        return "ok";
    }

    @RequestMapping("/sentFanout")
    public String sentFanout(String message){
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            if (message !=null){
                m.setInfo("say sentFanout "+i+message);
                m.setTitle("this is sentFanout "+i+message);
            }else {
                m.setInfo("say sentFanout "+i);
                m.setTitle("this is sentFanout "+i);
            }
            rabbitTemplate.convertAndSend("Fanout_Exchange",null,m.toString());
        }
        return "sentFanout ok";
    }
    @RequestMapping("/sentDirect")
    public String sentDirect(String message){
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            if (message !=null){
                m.setInfo("say sentDirect "+i+message);
                m.setTitle("this is sentDirect "+i+message);
            }else {
                m.setInfo("say sentDirect "+i);
                m.setTitle("this is sentDirect "+i);
            }
            rabbitTemplate.convertAndSend("Direct_Exchange","error",m+"error");
            rabbitTemplate.convertAndSend("Direct_Exchange","info",m+"info");
        }
        return "sentDirect ok";
    }

    @RequestMapping("/sentToipc")
    public String sentToipc(String message){
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            if (message !=null){
                m.setInfo("say sentDirect "+i+message);
                m.setTitle("this is sentDirect "+i+message);
            }else {
                m.setInfo("say sentDirect "+i);
                m.setTitle("this is sentDirect "+i);
            }
            rabbitTemplate.convertAndSend("Topic_Exchange","log.error",m+"error");
            rabbitTemplate.convertAndSend("Topic_Exchange","log.info",m+"count");
        }
        return "sentToipc ok";
    }

}

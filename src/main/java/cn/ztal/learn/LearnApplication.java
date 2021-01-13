package cn.ztal.learn;

import cn.ztal.learn.rabbit.Run;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LearnApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LearnApplication.class, args);
//        Run bean = run.getBean(Run.class);
//        bean.sent();
    }

}

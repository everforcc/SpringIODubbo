package cn.cc.apache_2_7_consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableDubbo(scanBasePackages = "cn.cc.apache_2_7_consumer")
@PropertySource("classpath:/application.yml")
@SpringBootApplication
public class Apache_27_ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Apache_27_ConsumerApplication.class, args);
    }

}

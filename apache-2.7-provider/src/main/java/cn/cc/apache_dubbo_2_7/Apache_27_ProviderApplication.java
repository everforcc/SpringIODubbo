package cn.cc.apache_dubbo_2_7;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

// dubbo扫描地址
@EnableDubbo(scanBasePackages = {"cn.cc.apache_dubbo_2_7.service"})
// TODO 扫描配置文件地址
@PropertySource("classpath:/application.yml")
@SpringBootApplication(scanBasePackages = {"cn.cc.apache_dubbo_2_7"})
public class Apache_27_ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Apache_27_ProviderApplication.class, args);
    }

}

/**
 * @Description
 * @Author everforcc
 * @Date 2022-10-18 15:27
 * Copyright
 */

package cn.cc.apache_2_7_consumer.controller;

import cn.cc.base.TouchDto;
import cn.cc.service.ITouchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TouchController {

    @DubboReference(
            cluster = "failfast",
            check = false,
            version = "1.0",
            group = "dev"
    )
    ITouchService iTouchService;

    @PostMapping("/touch")
    public String touch(@RequestBody TouchDto touchDto) {
        log.info("consumer --- touch = [{}]", touchDto);
        return iTouchService.touch(touchDto);
    }

    /**
     * 测试同步，异步调用
     */
    @GetMapping("/testAsync")
    public void testAsync() {
        log.info("consumer --- testAsync");
        iTouchService.consumerInvoker();
    }

}

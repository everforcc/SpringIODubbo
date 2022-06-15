/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-15 21:17
 * Copyright
 */

package cn.cc.dubboconsumer.controller;

import cn.cc.dubboconsumer.service.HelloDubboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/dubbo")
@RestController
public class DubboController {

    @Autowired
    HelloDubboService helloDubboService;

    @GetMapping("/say/{word}")
    public String say(@PathVariable("word") String word){
        log.info("consumer --- controller");
        return helloDubboService.sayWord(word);
    }

}

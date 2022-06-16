/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-16 10:45
 * Copyright
 */

package cn.cc.apache_2_7_consumer.controller;

import cn.cc.base.RPCDto;
import cn.cc.service.IDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DubboController {

    @DubboReference
    IDubboService iDubboService;

    @GetMapping("/say/{word}")
    public String say(@PathVariable("word") String word) {
        log.info("consumer --- word = [{}]", word);
        return iDubboService.say(word);
    }

    @PostMapping("/obj")
    public String obj(@RequestBody RPCDto rpcDto) {
        log.info("consumer --- obj = [{}]", rpcDto);
        return iDubboService.obj(rpcDto);
    }

}

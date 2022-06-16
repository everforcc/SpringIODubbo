/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-15 21:16
 * Copyright
 */

package cn.cc.dubboconsumer.service;

import cn.cc.dubbobase.service.IHelloDubboService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloDubboService {// implements IHelloDubboService

    @Reference
    IHelloDubboService iHelloDubboService;

    public String sayWord(String word) {
        log.info("consumer --- service");
        return iHelloDubboService.sayWord(word);
    }
}

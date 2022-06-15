/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-15 21:11
 * Copyright
 */

package cn.cc.dubboprovider.service;

import cn.cc.dubbobase.service.IHelloDubboService;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloDubboServiceImpl implements IHelloDubboService {
    @Override
    public String sayWord(String word) {
        log.info("provider --- service");
        return "Hello: " + word;
    }
}

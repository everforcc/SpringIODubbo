/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-16 16:43
 * Copyright
 */

package cn.cc.apache_2_7_consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@Configuration
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String exception(final Exception exception) {
        log.info("处理公共异常");
        if (exception instanceof NoHandlerFoundException) {
            return "{ code : 404 }";
        } else {
            return "{ " + exception.getMessage() + " }";
        }
    }
}

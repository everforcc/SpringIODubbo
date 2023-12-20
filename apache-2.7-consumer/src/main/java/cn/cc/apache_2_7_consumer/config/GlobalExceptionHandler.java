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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@Configuration
@RestControllerAdvice
//@ControllerAdvice
public class GlobalExceptionHandler {


    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSize;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exception(final Exception exception) {
        log.info("处理公共异常");
        if (exception instanceof MaxUploadSizeExceededException) {
            return "{ code : 404 , msg: 文件大小超出限制}";
        } else if (exception instanceof NoHandlerFoundException) {
            // 如果  context-path: / 不是这样配置
            // 例如  context-path: /cc 那么访问 localhost:port/aa 那么就不会进入系统，会被 tomcat 拦截到
            return "{ code : 404 }";
        } else if (exception instanceof MissingServletRequestParameterException) {
            return "{ code : 500 , msg: 请求缺少必要参数}";
        } else if (exception instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException methodArgumentTypeMismatchException = (MethodArgumentTypeMismatchException) exception;
            String errMsg = "期望参数类型" + methodArgumentTypeMismatchException.getParameter().getParameterType();
            log.error(errMsg);
            return "{ code : 500 , msg: 参数类型不正确}";
        } else {
            return "{ code : 000, \r\n" + exception.getMessage() + " }";
        }
    }
}

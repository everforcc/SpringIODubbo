//package cn.cc.apache_2_7_consumer.config;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// * @Description
// * @Author everforcc
// * @Date 2023-12-20 18:52
// * Copyright
// */
//@Slf4j
//@ControllerAdvice
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//
//    public RestResponseEntityExceptionHandler() {
//        super();
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        log.error(ex.getMessage(), ex);
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute("javax.servlet.error.exception", ex, 0);
//        }
//
//        log.info("异常原始信息: \r\n{}", body);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code", status.value());
//        jsonObject.put("msg", ex.getMessage());
//        return new ResponseEntity(jsonObject.toJSONString(), headers, status);
//    }
//
//}

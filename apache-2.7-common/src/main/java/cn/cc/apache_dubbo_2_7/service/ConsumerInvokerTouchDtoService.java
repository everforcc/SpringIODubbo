package cn.cc.apache_dubbo_2_7.service;

import cn.cc.apache_dubbo_2_7.component.ConsumerInvoker;
import cn.cc.base.TouchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author everforcc
 * @Date 2023-12-20 14:58
 * Copyright
 */
@Service
@Slf4j
public class ConsumerInvokerTouchDtoService {
    @Resource
    private ConsumerInvoker<TouchDto> consumerInvoker;

    public void invokerMethod() {
        TouchDto touchDto = new TouchDto();
        touchDto.setStrA("A");
        touchDto.setStrB("B");
        log.info("执行同步方法");
        consumerInvoker.syncInvoke(touchDto, t -> this.touchDtoToString(t), null, null);
        log.info("执行异步方法");
        CompletableFuture<TouchDto> future = consumerInvoker.asyncInvoke(null, touchDto, t -> this.touchDtoAdd(t), t -> t.setStrC("异常情况"), t -> t.setDate(new Date()));
        log.info("异步执行完调用方法");
        future.whenComplete((d, t) -> {
            log.info("对象信息: {}", d);
            log.error("异常信息： {}", t.getMessage());
        });
    }

    private void touchDtoToString(TouchDto touchDto) {
        log.info(touchDto.toString());
    }

    private void touchDtoAdd(TouchDto touchDto) {
        if (touchDto.getI() == 0) {
            touchDto.setI(1);
        }
        touchDto.setI(touchDto.getI());
    }

}

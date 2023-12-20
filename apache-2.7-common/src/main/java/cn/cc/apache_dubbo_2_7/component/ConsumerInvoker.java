package cn.cc.apache_dubbo_2_7.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @Description 异步/同步 调用操作
 * @Author everforcc
 * @Date 2023-12-20 11:01
 * Copyright
 */
@EnableAsync
@Component
@Slf4j
@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
public class ConsumerInvoker<T> {

    /**
     * 异步调用操作
     *
     * @param threadContext     线程间传递信息，类似 netty attachment
     * @param t                 操作对象
     * @param invokeConsumer    异步方法
     * @param exceptionConsumer 异常操作
     * @param finallyConsumer   最终操作
     * @return 异步调用操作对象
     */
    @Async
    public CompletableFuture<T> asyncInvoke(Map<String, String> threadContext, T t, Consumer<T> invokeConsumer,
                                            Consumer<T> exceptionConsumer, Consumer<T> finallyConsumer) {
        try {
            // 比如传递日志
            invokeConsumer.accept(t);
        } catch (Exception e) {
            log.error("异步调用操作异常", e);
            if (exceptionConsumer != null) {
                exceptionConsumer.accept(t);
            }
        } finally {
            log.info("当前时间： {}", new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (finallyConsumer != exceptionConsumer) {
                finallyConsumer.accept(t);
            }
        }
        return CompletableFuture.completedFuture(t);
    }

    /**
     * 同步调用操作
     *
     * @param t                 操作对象
     * @param invokeConsumer    同步执行方法
     * @param exceptionConsumer 发生异常时操作
     * @param finallyConsumer   执行结束后的操作
     */
    public void syncInvoke(T t, Consumer<T> invokeConsumer,
                           Consumer<T> exceptionConsumer, Consumer<T> finallyConsumer) {
        try {
            invokeConsumer.accept(t);
        } catch (Exception e) {
            log.error("同步调用后续操作异常", e);
            if (exceptionConsumer != null) {
                exceptionConsumer.accept(t);
            }
        } finally {
            if (finallyConsumer != null) {
                finallyConsumer.accept(t);
            }
        }
    }

}

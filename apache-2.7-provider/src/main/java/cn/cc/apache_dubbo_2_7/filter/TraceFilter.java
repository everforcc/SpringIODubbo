/**
 * @Description
 * @Author everforcc
 * @Date 2022-12-09 18:48
 * Copyright
 */

package cn.cc.apache_dubbo_2_7.filter;

import cn.cc.constant.SysConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

/**
 * 可以移动到common
 * 如果有多个服务，都可以用
 */
@Slf4j
@Activate(group = {PROVIDER}, value = "traceFilter", order = -9999)
public class TraceFilter implements Filter {

    /**
     * 设置全局链路追踪id
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String logId = invocation.getAttachment(SysConstants.TraceId);
        log.info("logId: {}", logId);
        MDC.put(SysConstants.TraceId, logId);
        return invoker.invoke(invocation);
    }
}

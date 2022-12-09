/**
 * @Description
 * @Author everforcc
 * @Date 2022-12-09 18:48
 * Copyright
 */

package cn.cc.apache_2_7_consumer.filter;


import cn.cc.constant.SysConstants;
import cn.cc.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class AppFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(SysConstants.TraceId, StringUtils.uuid32());
        filterChain.doFilter(servletRequest, servletResponse);
    }

}

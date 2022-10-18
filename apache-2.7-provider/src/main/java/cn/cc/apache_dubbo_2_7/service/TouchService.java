/**
 * @Description
 * @Author everforcc
 * @Date 2022-10-18 15:17
 * Copyright
 */

package cn.cc.apache_dubbo_2_7.service;

import cn.cc.base.TouchDto;
import cn.cc.service.ITouchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DubboService(cluster = "failfast", version = "1.0", group = "dev")
public class TouchService implements ITouchService {

    @Override
    public String touch(TouchDto touchDto) {
        String result = touchDto.toString();
        log.info("result: {}", result);
        return result;
    }

}

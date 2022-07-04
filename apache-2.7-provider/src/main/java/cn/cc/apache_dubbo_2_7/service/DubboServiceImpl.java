/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-16 09:06
 * Copyright
 */

package cn.cc.apache_dubbo_2_7.service;

import cn.cc.base.CommonFiled;
import cn.cc.base.RPCDto;
import cn.cc.service.IDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Slf4j
// 加载到spring里面
@Service("dubboServiceImpl")
// dubbo的service
//@DubboService(version = "1.0.1", group = "cc")
@DubboService
public class DubboServiceImpl implements IDubboService {
    @Override
    public String say(String word) {
        log.info("provider --- say = [{}]", word);
        return "Hello " + word;
    }

    @Override
    public String obj(RPCDto rpcDto) {
        log.info("provider --- obj = [{}]", rpcDto);
        return rpcDto.toString();
    }

    @Override
    public String str(RPCDto rpcDto) {
        log.info("provider --- obj_21 = [{}]", rpcDto);
        return rpcDto.toString();
    }

    @Override
    public String saveAppendUpdate(RPCDto rpcDto) {
        log.info("provider --- saveAppendUpdate = [{}]", rpcDto);
        return rpcDto.toString();
    }

//    @Override
//    public void save(RPCDto rpcDto) {
//
//    }

//    @Override
//    public void update(RPCDto rpcDto) {
//        log.info("provider --- obj_2_1 = [{}]", rpcDto);
//    }

    @Override
    public String strCommon(RPCDto rpcDto) {
        log.info("provider --- obj_2_2 = [{}]", rpcDto);
        return rpcDto.toString();
    }

}

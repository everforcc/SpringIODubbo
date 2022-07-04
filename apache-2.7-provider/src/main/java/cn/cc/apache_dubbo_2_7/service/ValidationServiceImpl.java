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

import cn.cc.base.ValidationDto;
import cn.cc.service.IValidationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Slf4j
// 加载到spring里面
@Service("dubboServiceImpl")
// dubbo的service
//@DubboService(version = "1.0.1", group = "cc")
@DubboService
public class ValidationServiceImpl implements IValidationService {
    @Override
    public String say(String word) {
        log.info("provider --- say = [{}]", word);
        return "Hello " + word;
    }

    @Override
    public String obj(ValidationDto validationDto) {
        log.info("provider --- obj = [{}]", validationDto);
        return validationDto.toString();
    }

    @Override
    public String saveWithUpdate(ValidationDto validationDto) {
        log.info("provider --- obj_21 = [{}]", validationDto);
        return validationDto.toString();
    }

    @Override
    public String saveAppendUpdate(ValidationDto validationDto) {
        log.info("provider --- saveAppendUpdate = [{}]", validationDto);
        return validationDto.toString();
    }

    @Override
    public String strCommon(ValidationDto validationDto) {
        log.info("provider --- obj_2_2 = [{}]", validationDto);
        return validationDto.toString();
    }

}

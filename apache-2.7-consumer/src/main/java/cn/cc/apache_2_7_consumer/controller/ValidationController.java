/**
 * Project:TODO ADD PROJECT NAME SpringIODubbo
 *
 * @Description
 * @Author Author Date Description
 * ------ ------ ------
 *    TODO 开发人员邮箱前缀 调整时间 年-月-日 主要改动点>5字符
 * @Date 2022-06-16 10:45
 * Copyright
 */

package cn.cc.apache_2_7_consumer.controller;

import cn.cc.base.ValidationDto;
import cn.cc.service.IValidationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ValidationController {

    @DubboReference
    IValidationService iValidationService;

    @GetMapping("/say/{word}")
    public String say(@PathVariable("word") String word) {
        log.info("consumer --- word = [{}]", word);
        return iValidationService.say(word);
    }

    @PostMapping("/obj")
    public String obj(@RequestBody ValidationDto validationDto) {
        log.info("consumer --- obj = [{}]", validationDto);
        return iValidationService.obj(validationDto);
    }

    @PostMapping("/update")
    public String update(@RequestBody ValidationDto validationDto) {
        log.info("consumer --- obj = [{}]", validationDto);
        return iValidationService.update(validationDto);
    }

    @PostMapping("/saveWithUpdate")
    public String saveWithUpdate(@RequestBody ValidationDto validationDto) {
        log.info("consumer --- saveWithUpdate = [{}]", validationDto);
        return iValidationService.saveWithUpdate(validationDto);
    }

    @PostMapping("/saveAppendUpdate")
    public String saveAppendUpdate(@RequestBody ValidationDto validationDto) {
        log.info("consumer --- saveAppendUpdate = [{}]", validationDto);
        return iValidationService.saveAppendUpdate(validationDto);
    }

    @PostMapping("/strCommon")
    public String strCommon(@RequestBody ValidationDto validationDto) {
        log.info("consumer --- saveAppendUpdate = [{}]", validationDto);
        return iValidationService.strCommon(validationDto);
    }

}

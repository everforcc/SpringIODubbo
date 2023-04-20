package cn.cc.service;

import cn.cc.base.ValidationDto;

import javax.validation.GroupSequence;

public interface IValidationService {

    /**
     * 简单参数传递
     *
     * @param word str参数
     * @return 返回值
     */
    String say(String word);

    /**
     * 1. 单个参数校验
     */
    @interface Obj {}
    String obj(ValidationDto validationDto);

    /**
     * 2 分组关联校验
     * 2.1 自有字段
     */
    @GroupSequence({Save.class, Update.class})
    @interface SaveWithUpdate { }
    String saveWithUpdate(ValidationDto validationDto);

    /**
     * 只有 Update 生效
     */
    @GroupSequence(Update.class)
    @interface SaveAppendUpdate { }
    String saveAppendUpdate(ValidationDto validationDto);

    @interface Save { }
    default void save(ValidationDto validationDto) {
        // 不做任何逻辑处理,仅分组校验使用
    }

    /**
     * 测试自有字段
     */
    @interface Update { }
    //@IValidationCheckService.Update
    default String update(ValidationDto validationDto) {
        // 不做任何逻辑处理,仅分组校验使用
        return validationDto.toString();
    }

    ;

    /**
     * 测试继承字段
     */
    @GroupSequence({Save.class, Update.class, CommonFiledService.StrCommonFiled.class})
    @interface StrCommon { }
    String strCommon(ValidationDto validationDto);

}

package cn.cc.service;

import cn.cc.base.CommonFiled;
import cn.cc.base.RPCDto;

import javax.validation.GroupSequence;

public interface IDubboService {

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
    String obj(RPCDto rpcDto);

    /**
     * 2 分组关联校验
     * 2.1 自有字段
     */
    @GroupSequence({Save.class, Update.class})
    @interface Str {}
    String str(RPCDto rpcDto);

    /**
     * 2 分组关联校验
     * 2.2 继承字段
     */
    @GroupSequence(Update.class)
    @interface SaveAppendUpdate {}
    String saveAppendUpdate(RPCDto rpcDto);

    @interface Save {}
    default void save(RPCDto rpcDto){
        // 不做任何逻辑处理,仅分组校验使用
    };
    /**
     * 测试自有字段
     */
    @interface Update {}
    default void update(RPCDto rpcDto){
        // 不做任何逻辑处理,仅分组校验使用
    };

    /**
     * 测试继承字段
     */
    @GroupSequence({Save.class,Update.class,CommonFiledService.StrCommonFiled.class})
    @interface StrCommon {}
    String strCommon(RPCDto rpcDto);

}

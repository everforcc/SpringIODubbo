package cn.cc.service;

import cn.cc.base.TouchDto;

public interface ITouchService {

    /**
     * 测试 对象字段校验 三种情况
     */
    @interface Touch {
    }

    String touch(TouchDto touchDto);

    /**
     * 测试同步，异步调用
     */
    void consumerInvoker();

}

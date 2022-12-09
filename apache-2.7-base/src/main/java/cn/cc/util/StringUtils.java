package cn.cc.util;

import java.util.UUID;

public class StringUtils {

    /**
     * 生成uuid并去掉中间 -
     *
     * @return uuid32
     */
    public static String uuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
